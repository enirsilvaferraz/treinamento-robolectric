package com.treinamento.robolectric

import kotlinx.android.synthetic.main.activity_main.*
import org.junit.Assert.*
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.Robolectric
import org.robolectric.RobolectricTestRunner
import org.robolectric.Shadows
import org.robolectric.shadows.ShadowToast

@RunWith(RobolectricTestRunner::class)
class MainActivityTest {

    lateinit var activity: MainActivity

    @Before
    fun setUp() {
        activity = Robolectric.buildActivity(MainActivity::class.java).setup().get()
    }

    @Test
    fun `Deve exibir o texto Tela de Login`() {

        assertEquals("Tela de Login", activity.login_title.text)
    }

    @Test
    fun `Deve abrir a tela de lista em caso de login com sucesso`() {

        activity.login_field_username.setText("username")
        activity.login_field_password.setText("12345")

        activity.login_buttom.performClick()

        val shadowActivity = Shadows.shadowOf(activity)
        val intent = Shadows.shadowOf(shadowActivity.nextStartedActivity)

        assertEquals(MainListActivity::class.java, intent.intentClass)
    }

    @Test
    fun `Deve exibir o texto informe o nome do usuario`() {

        assertEquals("Informe o nome do usuário", activity.login_label_username.text)
    }

    @Test
    fun `Deve exibir o texto informe a senha`() {

        assertEquals("Informe a senha", activity.login_label_password.text)
    }

    @Test
    fun `Deve exibir o botao com o texto login`() {

        assertEquals("Login", activity.login_buttom.text)
    }

    @Test
    fun `Deve exibir o botao de login desabilitado quando os campos nao tiverem preenchidos`() {

        activity.login_field_username.setText("")
        activity.login_field_password.setText("")

        assertFalse(activity.login_buttom.isEnabled)
    }

    @Test
    fun `Deve exibir o botao de login habilitado quando os campos tiverem preenchidos`() {

        activity.login_field_username.setText("username")
        activity.login_field_password.setText("12345")

        assertTrue(activity.login_buttom.isEnabled)
    }

    @Test
    fun `Deve exibir mensagem de usuario invalido`() {

        activity.login_field_username.setText("emanresu")
        activity.login_field_password.setText("54321")

        activity.login_buttom.performClick()

        assertEquals("Usuario invalido", ShadowToast.getTextOfLatestToast())
    }

    @Test
    fun `Deve exibir mensagem de senha errada`() {

        activity.login_field_username.setText("username")
        activity.login_field_password.setText("54321")

        activity.login_buttom.performClick()

        assertEquals("A senha está errada", ShadowToast.getTextOfLatestToast())
    }
}