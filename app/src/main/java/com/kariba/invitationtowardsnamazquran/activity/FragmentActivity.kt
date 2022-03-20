package com.kariba.invitationtowardsnamazquran.activity

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import com.kariba.invitationtowardsnamazquran.R
import com.kariba.invitationtowardsnamazquran.fragment.HomeFragment
import com.kariba.invitationtowardsnamazquran.fragment.QuranRecitationRulesFragment
import com.kariba.invitationtowardsnamazquran.fragment.TasbihFragment
import kotlinx.android.synthetic.main.activity_fragment.*
import java.lang.Exception

class FragmentActivity : AppCompatActivity() {

    private val quranRecitationRulesFragment : QuranRecitationRulesFragment = QuranRecitationRulesFragment()
    private val homeFragment : HomeFragment = HomeFragment()
    private val tasbihFragment : TasbihFragment = TasbihFragment()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fragment)
        setSupportActionBar(toolbar)

        intent.getStringExtra(SHOULD_SHOW).let {
            when(it) {
                TAG_QURAN_RECITATION_RULES -> {
                    supportActionBar?.title = getString(R.string.quran_recitation_rules_title)
                    commitFragmentTransaction(quranRecitationRulesFragment, it)
                }

                TAG_HOME -> {
                    commitFragmentTransaction(homeFragment, it)
                }

                TAG_TASBIH ->{
                    supportActionBar?.title = getString(R.string.tasbih)
                    commitFragmentTransaction(tasbihFragment, it)
                }
            }
        }

        setBackPressed()
    }

    private fun setBackPressed() {
        toolbar.setNavigationOnClickListener {
            onBackPressed()
        }
    }

    private fun commitFragmentTransaction(fragment: Fragment, tag: String) {

        try {
            supportFragmentManager
                .beginTransaction()
                .replace(R.id.containerFragment , fragment, tag)
                .commit()

        }catch (ex : Exception){
            Log.d("hvj","$ex")
        }

    }

    companion object {

        const val SHOULD_SHOW : String = "SHOULD_SHOW"
        const val TAG_QURAN_RECITATION_RULES : String = "TAG_QURAN_RECITATION_RULES"
        const val TAG_HOME : String = "TAG_HOME"
        const val TAG_TASBIH : String = "TAG_TASBIH"

        fun startActivity(context: Context, tag: String){
            val intent = Intent(context, FragmentActivity::class.java)
            intent.putExtra(SHOULD_SHOW,tag)
            context.startActivity(intent)
        }
    }
}