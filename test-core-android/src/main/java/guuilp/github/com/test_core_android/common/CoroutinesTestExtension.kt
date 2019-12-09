package guuilp.github.com.test_core_android.common

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.TestCoroutineDispatcher
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.setMain
import org.junit.jupiter.api.extension.*

private val TEST_COROUTINE_DISPATCHER_NAMESPACE = ExtensionContext.Namespace.GLOBAL
private const val TEST_COROUTINE_DISPATCHER_KEY = "TEST_COROUTINE_DISPATCHER_KEY"

@ExperimentalCoroutinesApi
class CoroutinesTestExtension : BeforeEachCallback, AfterEachCallback, ParameterResolver {

    override fun beforeEach(context: ExtensionContext?) {
        Dispatchers.setMain(
            context?.root
                ?.getStore(TEST_COROUTINE_DISPATCHER_NAMESPACE)
                ?.get(TEST_COROUTINE_DISPATCHER_KEY, TestCoroutineDispatcher::class.java)!!
        )
    }

    override fun afterEach(context: ExtensionContext?) {
        Dispatchers.resetMain()
        context?.root
            ?.getStore(TEST_COROUTINE_DISPATCHER_NAMESPACE)
            ?.get(TEST_COROUTINE_DISPATCHER_KEY, TestCoroutineDispatcher::class.java)
            ?.cleanupTestCoroutines()
    }

    override fun supportsParameter(
        parameterContext: ParameterContext?,
        extensionContext: ExtensionContext?
    ) = parameterContext?.parameter?.type == TestCoroutineDispatcher::class.java

    override fun resolveParameter(
        parameterContext: ParameterContext?,
        extensionContext: ExtensionContext?
    ) = getTestCoroutineDispatcher(extensionContext).let { dipatcher ->
        dipatcher ?: saveAndReturnTestCoroutineDispatcher(extensionContext)
    }

    private fun getTestCoroutineDispatcher(context: ExtensionContext?) = context?.root
        ?.getStore(TEST_COROUTINE_DISPATCHER_NAMESPACE)
        ?.get(TEST_COROUTINE_DISPATCHER_KEY, TestCoroutineDispatcher::class.java)

    private fun saveAndReturnTestCoroutineDispatcher(extensionContext: ExtensionContext?) =
        TestCoroutineDispatcher().apply {
            extensionContext?.root
                ?.getStore(TEST_COROUTINE_DISPATCHER_NAMESPACE)
                ?.put(TEST_COROUTINE_DISPATCHER_KEY, this)
        }

}