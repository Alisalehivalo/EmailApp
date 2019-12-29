package ir.airport.emailapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;


public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
EditText mail,cMail,subject,ads,fltTime,ogN,acIdentification,typeAC,equp1,equp2,dep,timeFlt,speed,level,route1,route2,dest,eet,alt1,alt2,other;
    String[] rule = { "I","V","Y", "Z" };
    String[] type = { "S","N","G", "M" ,"I"};
    String[] turbo = { "L","M","H"};
    String ruleSelected,typeSelected,turboSelected;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Spinner spin_rule = (Spinner) findViewById(R.id.rules1);
        Spinner spin_type = (Spinner) findViewById(R.id.spin_type);
        Spinner spin_turbo = (Spinner) findViewById(R.id.spin_turbulance);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, rule);
        ArrayAdapter<String> adapter1 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, type);
        ArrayAdapter<String> adapter2 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, turbo);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spin_rule.setAdapter(adapter);
        spin_type.setAdapter(adapter1);
        spin_turbo.setAdapter(adapter2);
        spin_rule.setOnItemSelectedListener(this);
        spin_type.setOnItemSelectedListener(this);
        spin_turbo.setOnItemSelectedListener(this);
        mail=findViewById(R.id.email);
        subject=findViewById(R.id.subject);
        //cMail=findViewById(R.id.cEmail);
        ads=findViewById(R.id.ads);
        fltTime=findViewById(R.id.fillingTime);
        ogN=findViewById(R.id.ogn);
        acIdentification=findViewById(R.id.ident);
        //rules=findViewById(R.id.rules);
        //typeFLT=findViewById(R.id.type);
        //num=findViewById(R.id.num);
        typeAC=findViewById(R.id.typeAC);
        //wTurbulance=findViewById(R.id.wTurbulance);
        equp1=findViewById(R.id.equip1);
        equp2=findViewById(R.id.equip2);
        dep=findViewById(R.id.dep);
        timeFlt=findViewById(R.id.timeFlt);
        speed=findViewById(R.id.speed);
        level=findViewById(R.id.level);
        route1=findViewById(R.id.route1);
        route2=findViewById(R.id.route2);
        dest=findViewById(R.id.dest);
        eet=findViewById(R.id.eet);
        alt1=findViewById(R.id.alt1);
        alt2=findViewById(R.id.alt2);
        other=findViewById(R.id.other);
        Button send=findViewById(R.id.send);
        Button clear=findViewById(R.id.clear);

        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mail.getText().toString().trim().equalsIgnoreCase("")) {

                    mail.setError("Please enter Email addresses,This field can not be blank");
                } else if (subject.getText().toString().trim().equalsIgnoreCase("")) {
                    subject.setError("Please enter Subject,This field can not be blank");
                } else if (ads.getText().toString().trim().equalsIgnoreCase("")) {
                    ads.setError("Please enter AFTN addresses,This field can not be blank");
                } else if (fltTime.getText().toString().trim().equalsIgnoreCase("")) {
                    fltTime.setError("Please enter Filled Time,This field can not be blank");
                } else if (ogN.getText().toString().trim().equalsIgnoreCase("")) {
                    ogN.setError("Please enter OGN AFTN address,This field can not be blank");
                } else if (acIdentification.getText().toString().trim().equalsIgnoreCase("")) {
                    acIdentification.setError("Please enter A/C Identification,This field can not be blank");
                } else if (typeAC.getText().toString().trim().equalsIgnoreCase("")) {
                    typeAC.setError("Please enter type of A/C,This field can not be blank");
                } else if (equp1.getText().toString().trim().equalsIgnoreCase("")) {
                    equp1.setError("Please enter Equipment on-board,This field can not be blank");
                } else if (dep.getText().toString().trim().equalsIgnoreCase("")) {
                    dep.setError("Please enter DEP AD AFTN Location indicator,This field can not be blank");
                } else if (timeFlt.getText().toString().trim().equalsIgnoreCase("")) {
                    timeFlt.setError("Please enter Time of Flight,This field can not be blank");
                } else if (speed.getText().toString().trim().equalsIgnoreCase("")) {
                    speed.setError("Please enter Speed,This field can not be blank");
                } else if (level.getText().toString().trim().equalsIgnoreCase("")) {
                    level.setError("Please enter Cruise level,This field can not be blank");
                } else if (route1.getText().toString().trim().equalsIgnoreCase("")) {
                    route1.setError("Please enter Route of Flight,This field can not be blank");
                } else if (dest.getText().toString().trim().equalsIgnoreCase("")) {
                    dest.setError("Please enter DEST AD AFTN Location indicator,This field can not be blank");
                } else if (eet.getText().toString().trim().equalsIgnoreCase("")) {
                    eet.setError("Please enter EET,This field can not be blank");
                } else {
                    sendmail();
                }
            }
        });

        clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mail.setText("");
                subject.setText("");
                ads.setText("");
                fltTime.setText("");
                ogN.setText("");
                acIdentification.setText("");
                //rules.setText("");
                //typeFLT.setText("");
                //num.setText("");
                typeAC.setText("");
                //wTurbulance.setText("");
                equp1.setText("");
                equp2.setText("");
                dep.setText("");
                timeFlt.setText("");
                speed.setText("");
                level.setText("");
                route1.setText("");
                route2.setText("");
                dest.setText("");
                eet.setText("");
                alt1.setText("");
                alt2.setText("");
                other.setText("");

            }
        });

    }

    private void sendmail() {
        String addressee=mail.getText().toString().trim();
        //String cAddressee=cMail.getText().toString().trim();
        String SubjectMail=subject.getText().toString().trim();
        String adress="FF "+ads.getText().toString().toUpperCase()+"\n";
        String origin=fltTime.getText().toString()+" "+ogN.getText().toString().toUpperCase()+"\n";
        String FPL_MSG="(FPL-"+acIdentification.getText().toString().toUpperCase()+"-"+ruleSelected+typeSelected+"\n"+
                "-"+typeAC.getText().toString().toUpperCase()+"/"+turboSelected+"-"+equp1.getText().toString().toUpperCase()+"/"+equp2.getText().toString().toUpperCase()+"\n"+
                "-"+dep.getText().toString().toUpperCase()+timeFlt.getText().toString().toUpperCase()+"\n"+
                "-"+speed.getText().toString().toUpperCase()+level.getText().toString().toUpperCase()+route1.getText().toString().toUpperCase()+route2.getText().toString().toUpperCase()+"\n"+
                "-"+dest.getText().toString().toUpperCase()+eet.getText().toString()+" "+alt1.getText().toString().toUpperCase()+" "+alt2.getText().toString().toUpperCase()+"\n"+
                "-"+other.getText().toString().toUpperCase()+")"+"\n";
        Log.d("FPL",FPL_MSG);
        String txtMail=adress+origin+FPL_MSG+"\n"+"This Message Created on Aeronautical Messaging Android Application";
        Log.d("txt",txtMail);
        //if (!cAddressee.isEmpty()) {
            JavaMailAPI javaMailAPI = new JavaMailAPI(this, addressee,  SubjectMail, txtMail);
            javaMailAPI.execute();
        //}else {
            //JavaMailAPI javaMailAPI = new JavaMailAPI(this, addressee,"akbarsalehi@gmail.com", SubjectMail, txtMail);
            //javaMailAPI.execute();
        //}
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        ruleSelected=rule[position];
        typeSelected=type[position];
        turboSelected=turbo[position];

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
