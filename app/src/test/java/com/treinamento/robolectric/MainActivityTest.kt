package com.treinamento.robolectric

import android.widget.TextView
import kotlinx.android.synthetic.main.activity_main.*
import org.junit.Assert.*
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.Robolectric
import org.robolectric.RobolectricTestRunner
import org.robolectric.Shadows
import org.robolectric.annotation.Config

@RunWith(RobolectricTestRunner::class)
class MainActivityTest {

    lateinit var activity:MainActivity

    @Before
    fun setUp() {
        activity = Robolectric.buildActivity(MainActivity::class.java).setup().get()
    }

    @Test
    fun `Deve exibir o texto Tela de Login`(){

        assertEquals("Tela de Login", activity.login_title.text.toString())
    }

    @Test
    fun `Deve abrir a tela de lista em caso de login com sucesso`(){

        activity.login_field_username.setText("username")
        activity.login_field_password.setText("12345")

        activity.login_buttom.performClick()

        val shadowActivity = Shadows.shadowOf(activity)
        val intent = Shadows.shadowOf(shadowActivity.nextStartedActivity)

        assertEquals(MainListActivity::class.java, intent.intentClass)
    }

    @Test
    fun `Deve exibir o texto informe o nome do usuario`() {

    }

    @Test
    fun `Deve exibir o texto informe a senha`() {

    }

    @Test
    fun `Deve exibir o botao com o texto login`() {

    }

    @Test
    fun `Deve exibir o botao de login desabilitado quando os campos nao tiverem preenchidos`() {

    }

    @Test
    fun `Deve exibir o botao de login habilitado quando os campos tiverem preenchidos`() {

    }

    @Test
    fun `Deve exibir mensagem de usuario invalido`() {

    }

    @Test
    fun `Deve exibir mensagem de senha errada`() {

    }
}