package com.ddp.chambita

import android.os.Bundle
import android.view.Menu
import android.widget.ImageView
import android.widget.TextView
import com.google.android.material.navigation.NavigationView
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import androidx.drawerlayout.widget.DrawerLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.ddp.chambita.databinding.ActivityMainBinding
import de.hdodenhof.circleimageview.CircleImageView

class MainActivity : AppCompatActivity() {

    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var binding: ActivityMainBinding

    public var owner = User("Naydeline Gonzalez", "nayde","gr210052@alumno.udb.edu.sv", "12345678")
    var trabajadores = workerExamples.workerEx
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.appBarMain.toolbar)

        val drawerLayout: DrawerLayout = binding.drawerLayout
        val navView: NavigationView = binding.navView
        val navController = findNavController(R.id.nav_host_fragment_content_main)
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.nav_explorar, R.id.nav_favoritos, R.id.nav_ajustes
            ), drawerLayout
        )
        setupActionBarWithNavController(navController, appBarConfiguration)
        navView.setupWithNavController(navController)

        initNavHeader()
    }
    fun initNavHeader(){

        val headerLayout = binding.navView.getHeaderView(0)
        val nameTextView = headerLayout.findViewById<TextView>(R.id.username)
        nameTextView.text = owner.username
        val emailTextView = headerLayout.findViewById<TextView>(R.id.name)
        emailTextView.text = owner.name

        val resourceID = resources.getIdentifier(owner.username, "drawable", applicationContext.packageName)
        val pictureView = headerLayout.findViewById<CircleImageView>(R.id.profile_image)
        if (resourceID != 0) {
            pictureView.setImageResource(resourceID)
        }
    }
    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.main, menu)
        return true
    }

    override fun onSupportNavigateUp(): Boolean {
        val navController = findNavController(R.id.nav_host_fragment_content_main)
        return navController.navigateUp(appBarConfiguration) || super.onSupportNavigateUp()
    }
}