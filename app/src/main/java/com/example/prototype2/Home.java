package com.example.prototype2;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.tabs.TabLayout;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.Objects;

public class Home extends AppCompatActivity {
    private Toolbar tolbar;
    private TabAccessAdapter adapter;
    private ImageView imgg;
    private DatabaseReference reference;
    FirebaseUser user;

    @SuppressLint("RestrictedApi")
    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        final TextView txt = findViewById(R.id.username_toolbar);
        tolbar = findViewById(R.id.toolbarworking);
        setSupportActionBar(tolbar);
        Objects.requireNonNull(getSupportActionBar()).setTitle("");
        getSupportActionBar().dispatchMenuVisibilityChanged(true);


        user = FirebaseAuth.getInstance().getCurrentUser();
        reference = FirebaseDatabase.getInstance().getReference("Users").child(user.getUid());


        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                User userr = dataSnapshot.getValue(User.class);
                assert userr != null;
                txt.setText(userr.getUsername());
//                if(userr.getImageURL().equals("noimage")){
//                    imgg.setImageResource(R.drawable.ic_account_circle_black_24dp);
//                }

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

//        TabLayout tablayout  = findViewById(R.id.tablayout);
//        ViewPager viewPagerr = findViewById(R.id.viewpager);
//        adapter = new TabAccessAdapter(getSupportFragmentManager());
//        viewPagerr.setAdapter(adapter);
//        tablayout.setupWithViewPager(viewPagerr);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.action_logout:
                FirebaseAuth.getInstance().signOut();
                startActivity(new Intent(Home.this,MainActivity.class));
                finish();

        }
        return true;
    }

}
