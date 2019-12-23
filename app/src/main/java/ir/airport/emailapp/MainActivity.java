package ir.airport.emailapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
EditText mail,cMail,subject,ads,fltTime,ogN,acIdentification,rules,typeFLT,num,typeAC,wTurbulance,equp1,equp2,dep,timeFlt,speed,level,route1,route2,dest,eet,alt1,alt2,other;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mail=findViewById(R.id.email);
        subject=findViewById(R.id.subject);
        cMail=findViewById(R.id.cEmail);
        ads=findViewById(R.id.ads);
        fltTime=findViewById(R.id.fillingTime);
        ogN=findViewById(R.id.ogn);
        acIdentification=findViewById(R.id.ident);
        rules=findViewById(R.id.rules);
        typeFLT=findViewById(R.id.type);
        num=findViewById(R.id.num);
        typeAC=findViewById(R.id.typeAC);
        wTurbulance=findViewById(R.id.wTurbulance);
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
                sendmail();
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
                rules.setText("");
                typeFLT.setText("");
                num.setText("");
                typeAC.setText("");
                wTurbulance.setText("");
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
        String cAddressee=cMail.getText().toString().trim();
        String SubjectMail=subject.getText().toString().trim();
        String adress="FF "+ads.getText().toString().toUpperCase()+"\n";
        String origin=fltTime.getText().toString()+" "+ogN.getText().toString().toUpperCase()+"\n";
        String FPL_MSG="(FPL-"+acIdentification.getText().toString().toUpperCase()+"-"+rules.getText().toString().toUpperCase()+typeFLT.getText().toString().toUpperCase()+"\n"+
                "-"+num.getText().toString()+typeFLT.getText().toString().toUpperCase()+"/"+wTurbulance.getText().toString().toUpperCase()+"-"+equp1.getText().toString().toUpperCase()+"/"+equp2.getText().toString().toUpperCase()+"\n"+
                "-"+dep.getText().toString().toUpperCase()+timeFlt.getText().toString().toUpperCase()+"\n"+
                "-"+speed.getText().toString().toUpperCase()+level.getText().toString().toUpperCase()+route1.getText().toString().toUpperCase()+route2.getText().toString().toUpperCase()+"\n"+
                "-"+dest.getText().toString().toUpperCase()+eet.getText().toString()+" "+alt1.getText().toString().toUpperCase()+" "+alt2.getText().toString().toUpperCase()+"\n"+
                "-"+other.getText().toString().toUpperCase()+")"+"\n";
        Log.d("FPL",FPL_MSG);
        String txtMail=adress+origin+FPL_MSG+"\n"+"This Message Created on Aeronautical Messaging-Android Application";
        Log.d("txt",txtMail);
        if (!cAddressee.isEmpty()) {
            JavaMailAPI javaMailAPI = new JavaMailAPI(this, addressee, cAddressee, SubjectMail, txtMail);
            javaMailAPI.execute();
        }else {
            JavaMailAPI javaMailAPI = new JavaMailAPI(this, addressee,"akbarsalehi@gmail.com", SubjectMail, txtMail);
            javaMailAPI.execute();
        }
    }
}
