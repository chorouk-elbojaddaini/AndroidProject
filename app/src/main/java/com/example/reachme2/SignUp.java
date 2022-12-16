package com.example.reachme2;

import androidx.appcompat.app.AppCompatActivity;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


public class SignUp extends AppCompatActivity implements View.OnClickListener{
    private EditText EditTextEmail, EditTextPassword,firstN,familyN;
    private TextView signIn;
    private Button btnSignUp;
    DBHelper DB;
    itemList[] jobsRecomendation = {
           new itemList(1,"manifacture poste","agencia","Participer au developement des des nouvelles fonctionnalités ","isis_enterprise","Manufacturing",1),
            new itemList(1,"Manifacture ingineere","agencia","Participer au developement des des nouvelles fonctionnalités ","isis_enterprise","Manufacturing",1),
            new itemList(1,"manifacturing","agencia","Participer au developement des des nouvelles fonctionnalités ","isis_enterprise","Manufacturing",1),
            new itemList(2,"Ingénieure concepteur android","amenage","Faire le chiffrage et ralisation des demandes de changement ","isis_enterprise","Computer/Information Technology",1),
            new itemList(3,"Ingénieure concepteur javascript","development","Ecrire des testes unitaires automatise ","isis_enterprise","Computer/Information Technology",1),
            new itemList(4,"Ingénieure concepteur .net","vis","Realiser la maintencance corrective et evloutive de l'application","isis_enterprise","Computer/Information Technology",1),
            new itemList(5,"Payroll clerk","agencia","Payroll clerks help a company's employees receive payment accurately and efficiently. ","isis_enterprise","Sales/Marketing",1),
            new itemList(6,"Conveyancer","fin"," Conveyancers combine their financial education with a knowledge of real estate law to help transfer property to a new owner. ","isis_enterprise","Sales",1),
            new itemList(7," Credit analyst","finance","Credit analysts usually work for banks or other money lenders to help assess the risk of lending money to clients.r ","isis_enterprise","Sales",1),
            new itemList(8,"Tax adviser","oif","Tax advisers help clients pay their taxes in the most efficient way possible. They help their clients understand what taxes they owe and how to pay them back,","isis_enterprise","Sales",1),
            new itemList(9,"Admin Assistant","foto"," Admin Assistant Employment Type: Full Time Salary: up to 3.5K AED all-inclusive, depending on experience and qualifications Job Location: Abu Dhabi, UAE About the Client","isis_enterprise","Admin/Human Ressources",1),
            new itemList(10,"HR Assistant","amenage"," GRADE Refrigeration is an Industrial Refrigeration contractor operating in the MENA region. ","isis_enterprise","Admin/Human Ressources",1),
            new itemList(11,"HR & Admin Assistant","oif","Maintain and Update personnel files, HR database, Reports with different information such as new hires, terminations, warnings, vacations and days off. ","isis_enterprise","Admin/Human Ressources",1),
            new itemList(12,"Electrical Engineer (Building Contracting)","agencia"," Developing, reviewing, updating, modifying, and approving electrical design plans and work schedules.","isis_enterprise","Building",1),
            new itemList(13,"Project Director","agencia","Minimum 20yrs out of which 15yrs experience in airport construction out of which having 10yrs experience on same position in Passenger Terminal Building","isis_enterprise","Building",1),
            new itemList(14,"Contacts Manager - Building/Civil ","agencia","Minimum 20yrs out of which 15yrs experience in airport construction out of which having 10yrs experience on same position in Passenger Terminal Building","isis_enterprise","Building",1),
            new itemList(1,"Ingénieure concepteur java","agencia","Participer au developement des des nouvelles fonctionnalités ","isis_enterprise","Arts/Media/Communication",1),
            new itemList(1,"Ingénieure concepteur java","agencia","Participer au developement des des nouvelles fonctionnalités ","isis_enterprise","Arts/Media/Communication",1),
            new itemList(17,"Quality Engineer","constr","This position is located at The Advanced Technology and Training Center – Middle Georgia, in Warner Robins, Georgia. It provides engineering support for aircraft and vehicle sustainment technology development and transition including vehicle maintenance, ","isis_enterprise","Enginnering",1),
            new itemList(18,"Sustainment Engineer","scale","This position is located at The Advanced Technology and Training Center – Middle Georgia, in Warner Robins, Georgia. It provides engineering support for aircraft and vehicle sustainment technology development and transition including vehicle maintenance, ","isis_enterprise","Enginnering",1),
            new itemList(19,"Sustainment Engineer","reprise","Support maintenance and/or manufacturing process optimization","1","Enginnering",1),
            new itemList(20,"Restaurant SErver ","photos","Take food and beverage orders and place order in point of service system.","1","Hotel/Restaurant",1),
            new itemList(21,"HouseKeeper","photos","We are hiring immediately for a full and part-time HOUSEKEEPER position","1","Hotel/Restaurant",1),
            new itemList(22,"Hotel Oregon Dishwasher","oif","We are hiring immediately for a full and part-time HOUSEKEEPER position","1","Hotel/Restaurant",1),
            new itemList(23,"Caregiver","oif","Looking to work for a home care company that values passion and rewards its caregivers with flexible scheduling, amazing benefits, consistent hours, and 24/7 support? Join Honor as a Care Professional We’re hiring immediately!","isis_enterprise","Healthcare",1),
            new itemList(24,"Patient Experience Associate","oif","Do you have the passion to make an impact on people’s lives? Then come join our team! CareCentrix is committed to making the home the center of patient care.","isis_enterprise","education",1),
            new itemList(25,"Scheduling Coordinator","v","As a Healthcare Customer Service Expert in our Client Services Team, you make a difference every time you facilitate the initiation and termination of the care and services provided.","isis_enterprise","education",1),
            new itemList(1,"Auditor","oif","Auditors check financial records for companies and financial institutions to assess their accuracy. Some auditors work for government agencies to establish whether companies'","1","education",1),
           /*new itemList(1,"Compliance officer","oif","Auditors check financial records for companies and financial institutions to assess their accuracy. Some auditors work for government agencies to establish whether companies'","1","Accounting",1),
            new itemList(1,"Cost estimator","oif","Cost estimators help building contractors determine how much a proposed building might cost. They research the cost of any materials, labor and machinery needed for the project and create an estimated cost for building it","1","Accounting",1)
*/
    };



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        EditTextEmail = (EditText) findViewById(R.id.EditTextEmail);
        firstN = (EditText) findViewById(R.id.EditTextFirstName);
        familyN = (EditText) findViewById(R.id.EditTextLastName);
        EditTextPassword = (EditText) findViewById(R.id.EditTextPassword);

        btnSignUp = (Button) findViewById(R.id.signUp);






        signIn = (TextView) findViewById(R.id.login);
        DB  = new DBHelper(this);

        signIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),SignIn.class);
                startActivity(intent);
            }
        });
        btnSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String userEmail = EditTextEmail.getText().toString();
                String firstName = firstN.getText().toString();
                String familyName = familyN.getText().toString();
                String pass = EditTextPassword.getText().toString();
                for(itemList item: jobsRecomendation){
                    boolean isInserted = DB.insertWork(item);

                }

                if(userEmail.equals("") || pass.equals("") || firstName.equals("") || familyName.equals("")){
                    Toast.makeText(SignUp.this,"please enter all fields",Toast.LENGTH_SHORT).show();
                } else if(!userEmail.contains("@")){
                    Toast.makeText(SignUp.this,"Email is not valid !",Toast.LENGTH_SHORT).show();

                }
                else if(pass.length()<7){
                    Toast.makeText(SignUp.this,"Password must be more than 7 characters",Toast.LENGTH_SHORT).show();

                }





                else {
                    Boolean CheckEmail = DB.checkEmail(userEmail);
                    if(CheckEmail == false){
                        Boolean insert = DB.insertData(userEmail,pass,firstName,familyName);

                        if(insert == true){
                            Toast.makeText(SignUp.this,"Registered successfully",Toast.LENGTH_SHORT).show();
                            Intent myIntent = new Intent(getApplicationContext(),SignIn.class);
                            startActivity(myIntent);
                        }else{
                            Toast.makeText(SignUp.this,"Registration failed",Toast.LENGTH_SHORT).show();

                        }
                    }else{
                        Toast.makeText(SignUp.this,"This email already exists !",Toast.LENGTH_SHORT).show();

                    }
                }

            }
        });

    }


    @Override
    public void onClick(View v){

}
}