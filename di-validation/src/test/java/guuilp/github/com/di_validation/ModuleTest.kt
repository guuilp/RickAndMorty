package guuilp.github.com.di_validation

import guuilp.github.com.character.detail.presentation.CharacterDetailViewModel
import guuilp.github.com.character.di.characterModule
import guuilp.github.com.data.di.dataModule
import guuilp.github.com.domain.di.domainModule
import guuilp.github.com.remote.di.remoteModule
import guuilp.github.com.test_core.util.CoroutinesTestRule
import kotlinx.coroutines.ExperimentalCoroutinesApi
import org.junit.Rule
import org.junit.Test
import org.koin.core.parameter.parametersOf
import org.koin.dsl.koinApplication
import org.koin.test.KoinTest
import org.koin.test.check.checkModules

@ExperimentalCoroutinesApi
class ModuleTest : KoinTest {
    @get:Rule
    val coroutinesRule = CoroutinesTestRule()

    @Test
    fun `checking modules`() {
        koinApplication {
            modules(
                listOf(
                    dataModule,
                    domainModule,
                    remoteModule,
                    characterModule
                )
            )
        }.checkModules {
            create<CharacterDetailViewModel> { parametersOf("1") }
        }
    }
}
