package com.example.newidentity;

import androidx.appcompat.app.AppCompatActivity;

import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.github.twocoffeesoneteam.glidetovectoryou.GlideToVectorYou;
import com.squareup.picasso.Picasso;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    private TextView textViewLastName;
    private TextView textViewFirstName;
    private TextView textViewGender;
    private TextView textViewAge;
    private TextView textViewPhone;
    private TextView textViewRegion;
    private TextView textViewBirthday;
    private TextView textViewEmail;
    private TextView textViewPassword;
    private TextView textViewCreditCard;
    private TextView textViewExpiration;
    private TextView textViewPin;
    private Button buttonGenerate;
    private Spinner spinner;
    private ImageView imageViewPortrait;
    private String gender;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        wireWidgets();
        setListeners();

// Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.gender_array, android.R.layout.simple_spinner_item);
// Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
// Apply the adapter to the spinner
        spinner.setAdapter(adapter);
    }

    private void setListeners() {

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                gender = adapterView.getItemAtPosition(i).toString().toLowerCase();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
                Toast.makeText(MainActivity.this, "No Gender Selected", Toast.LENGTH_SHORT).show();
            }
        });

        buttonGenerate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Retrofit retrofit = new Retrofit.Builder()
                        .baseUrl(IdentityService.BASE_URL)
                        .addConverterFactory(GsonConverterFactory.create())
                        .build();


                IdentityService identityService = retrofit.create(IdentityService.class);

                Call<Identity> identityCall = identityService.getIdentityByGender(gender);

                identityCall.enqueue(new Callback<Identity>() {
                    @Override
                    public void onResponse(Call<Identity> call, Response<Identity> response) {
                        Identity foundIdentity = response.body();
                        textViewLastName.setText("Last Name: " + foundIdentity.getSurname());
                        textViewFirstName.setText("First Name: " + foundIdentity.getName());
                        textViewAge.setText("Age: " + foundIdentity.getAge());
                        textViewPhone.setText("Phone: " + foundIdentity.getPhone());
                        textViewRegion.setText("Region: " + foundIdentity.getRegion());
                        textViewBirthday.setText("DoB: " + foundIdentity.getMdy());
                        textViewEmail.setText("Email: " + foundIdentity.getEmail());
                        textViewPassword.setText("Password: " + foundIdentity.getPassword());
                        textViewCreditCard.setText("Credit Card: " + foundIdentity.getNumber());
                        textViewExpiration.setText("Expiration: " + foundIdentity.getExpiration());
                        textViewPin.setText("PIN: " + foundIdentity.getPin());
                    }

                    @Override
                    public void onFailure(Call<Identity> call, Throwable t) {
                        Toast.makeText(MainActivity.this, t.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                });
                Uri avatarUri = Uri.parse("https://avatars.dicebear.com/v2/" + gender + "/" + Math.random() + ".svg");

                GlideToVectorYou.justLoadImage(MainActivity.this, avatarUri, imageViewPortrait);
                Log.d("Image","https://avatars.dicebear.com/v2/" + gender + "/" + Math.random() + ".svg");
            }
        });

    }

    public void wireWidgets(){
        textViewLastName = findViewById(R.id.textview_main_surname);
        textViewFirstName = findViewById(R.id.textview_main_name);
        textViewGender = findViewById(R.id.textview_main_gender);
        textViewAge = findViewById(R.id.textview_main_age);
        textViewPhone = findViewById(R.id.textview_main_phone);
        textViewRegion = findViewById(R.id.textview_main_region);
        textViewBirthday = findViewById(R.id.textview_main_birthday);
        textViewEmail = findViewById(R.id.textview_main_email);
        textViewPassword = findViewById(R.id.textview_main_password);
        textViewCreditCard = findViewById(R.id.textview_main_creditnumber);
        textViewExpiration = findViewById(R.id.textview_main_expiration);
        textViewPin = findViewById(R.id.textview_main_pin);
        buttonGenerate = findViewById(R.id.button_main_generate);
        imageViewPortrait = findViewById(R.id.imageview_main_image);
        spinner = findViewById(R.id.spinner_main_spinner);
    }


}
