package com.example.sama_sante;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;


public class RendezVousFragment extends Fragment {

    private EditText txtFisrtName,txtLastName;
    private CheckBox cb0level,cbBachelor,cbMaster;
    private Button btnSave;
    private String firstName,lastName, degrees;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_rendez_vous, container, false);

        txtFisrtName=view.findViewById(R.id.txtFirsttName);
        txtLastName=view.findViewById(R.id.txtLastName);
        cb0level=view.findViewById(R.id.cb0Level);
        cbBachelor=view.findViewById(R.id.cbBachelor);
        cbMaster=view.findViewById(R.id.cbMaster);
        btnSave=view.findViewById(R.id.btnSave);

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                firstName=txtFisrtName.getText().toString().trim();
                lastName=txtLastName.getText().toString().trim();
                degrees="";

                if (cb0level.isChecked()){
                    degrees=cb0level.getText().toString()+"";
                }
                if (cbBachelor.isChecked()){
                    degrees=cbBachelor.getText().toString()+"";
                }
                if (cbMaster.isChecked()){
                    degrees=cbMaster.getText().toString()+"";
                }

                String resume=lastName+"\n\n"+firstName+"\n\n"+degrees;

                if(firstName.isEmpty() || lastName.isEmpty() || degrees.isEmpty())
                {
                    Toast.makeText(getActivity(),getString(R.string.error_field), Toast.LENGTH_SHORT).show();
                }else {
                    Toast.makeText(getActivity(), resume, Toast.LENGTH_SHORT).show();
                }
            }
        });
        return view;
    }
}
