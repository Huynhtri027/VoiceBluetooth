package com.voicebluetooth;


import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Toast;


/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentChangeCode extends DialogFragment {

    View view;

    EditText etCode;
    Button btnSaveCode;
    CheckBox checkbox;
    StoreinSp sp;

    public FragmentChangeCode() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_change_code, container, false);

        btnSaveCode = (Button) view.findViewById(R.id.btn_save_code);
        etCode = (EditText) view.findViewById(R.id.et_code);
        checkbox = (CheckBox) view.findViewById(R.id.checkbox);

        sp = new StoreinSp(getActivity());

        if (sp.getStoredDate("bt_code") == null) {
            checkbox.setVisibility(View.GONE);
        } else {

            checkbox.setVisibility(View.VISIBLE);
        }

        checkbox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

                if (isChecked) {
                    etCode.setText(sp.getStoredDate("bt_code"));
                    etCode.setSelection(etCode.getText().length());
                } else {
                    etCode.setText("");
                }


            }
        });

        btnSaveCode.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (!etCode.getText().toString().equals("")) {

                    mSaveCode(etCode.getText().toString());

                } else {
                    Toast.makeText(getActivity(), "Please Enter Code", Toast.LENGTH_SHORT).show();
                }

            }
        });

        return view;
    }

    private void mSaveCode(String s) {


        sp.storeinSp("bt_code", s);

        Toast.makeText(getActivity(), "Code Saved... Please Restart App", Toast.LENGTH_SHORT).show();

        dismiss();

    }

}
