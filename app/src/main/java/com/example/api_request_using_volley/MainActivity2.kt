package com.example.api_request_using_volley

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.android.volley.Request
import com.android.volley.VolleyError
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import org.json.JSONException
import org.json.JSONObject


class MainActivity2 : AppCompatActivity() {
    private lateinit var totalCasesWorld: TextView
    private lateinit var totalDeathsWorld: TextView
    private lateinit var totalRecoveredWorld: TextView
    private lateinit var updateWorld: TextView
    private lateinit var ui : Button
    private lateinit var search1 : Button

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
        totalCasesWorld = findViewById(R.id.newcase)
        totalDeathsWorld = findViewById(R.id.deathcase)
        totalRecoveredWorld = findViewById(R.id.recovercase)
        updateWorld = findViewById(R.id.update)
        ui = findViewById(R.id.ui)
        search1 = findViewById(R.id.search1)

        ui.setOnClickListener {
            intent = Intent(this,Ui_practice::class.java)
            startActivity(intent)
        }
        search1.setOnClickListener {
            intent = Intent(this,search::class.java)
            startActivity(intent)
        }
        data

    }

    //Create a JSON object containing information from the API.
    private val data: Unit
        private get() {
            val myUrl = "https://corona.lmao.ninja/v2/all"
            val myRequest = StringRequest(
                Request.Method.GET, myUrl,
                { response: String? ->
                    try {
                        //Create a JSON object containing information from the API.
                        val myJsonObject = JSONObject(response)
                        totalCasesWorld.text = myJsonObject.getString("cases")
                        totalRecoveredWorld.text = myJsonObject.getString("recovered")
                        totalDeathsWorld.text = myJsonObject.getString("deaths")
                        updateWorld.text = myJsonObject.getString("updated")
                    } catch (e: JSONException) {
                        e.printStackTrace()
                    }
                }
            ) { volleyError: VolleyError ->
                Toast.makeText(this,volleyError.message, Toast.LENGTH_SHORT).show()
            }
            var request=Volley.newRequestQueue(this)
            request.add(myRequest)
        }




}