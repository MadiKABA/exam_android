package com.example.sama_sante;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;


public class CliniqueFragment extends Fragment {

    private ListView listeCliniques;
    private String [] tabClinique,tabDetails;
    private String clinique,details;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_clinique, container, false);
        listeCliniques=view.findViewById(R.id.listCliniques);
        tabClinique=getResources().getStringArray(R.array.tab_hopitaux);
        tabDetails=getResources().getStringArray(R.array.tab_detail);
        ArrayAdapter<String> adapter=new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1,tabClinique);
        listeCliniques.setAdapter(adapter);//chargement des donnees sur la liste

        listeCliniques.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                clinique=tabClinique[i];
                details=tabDetails[i];

                AlertDialog.Builder dialog=new AlertDialog.Builder(getActivity());
                dialog.setIcon(R.mipmap.ic_launcher);
                dialog.setTitle(clinique);
                dialog.setMessage(details);

                dialog.setNegativeButton(getString(R.string.back),null);
                dialog.setPositiveButton(getString(R.string.inscription), new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                      getFragmentManager().beginTransaction()
                                .replace(R.id.nav_host_fragment_content_home, new RendezVousFragment())
                                .addToBackStack(null)
                                .commit();
                    }
                });
                dialog.show();
            }
        });

        return view;
    }
}