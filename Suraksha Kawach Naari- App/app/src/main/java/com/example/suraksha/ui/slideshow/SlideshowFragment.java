package com.example.suraksha.ui.slideshow;

import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.example.suraksha.PhoneBookAdapter;
import com.example.suraksha.R;
import com.example.suraksha.phonebook;

import java.util.ArrayList;
import java.util.List;

public class SlideshowFragment extends Fragment {

    private ListView lvPhone;


    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        View v = inflater.inflate(R.layout.phonebook2, container, false);

        lvPhone = (ListView) v.findViewById(R.id.listPhone);

        List<phonebook> listPhoneBook = new ArrayList<phonebook>();
        listPhoneBook.add(new phonebook(
                BitmapFactory.decodeResource(getResources(), R.drawable.ic_baseline_people_24),
                "  Arpit Sharma", "  "+"9414477801", "  "+"ar.sharma89141@gmail.com"));
        listPhoneBook.add(new phonebook(
                BitmapFactory.decodeResource(getResources(), R.drawable.ic_baseline_people_24),
                "  Bhupendra Saini", "  "+"9777555922", " "+"asishsaini@gmail.com"));
        listPhoneBook.add(new phonebook(
                BitmapFactory.decodeResource(getResources(), R.drawable.ic_baseline_people_24),
                "  Chhatrapal Prajapat", "  "+"6345646743", "  "+"infocp27@gmail.com"));
        listPhoneBook.add(new phonebook(
                BitmapFactory.decodeResource(getResources(), R.drawable.ic_baseline_people_24),
                "  AP Singh", "  "+"8593467431", "  "+"apsingh@gmail.com"));
        listPhoneBook.add(new phonebook(
                BitmapFactory.decodeResource(getResources(), R.drawable.ic_baseline_people_24),
                "  Megha Kumari", "  "+"65885494884", "  "+"meghakumari@gmail.com"));
        PhoneBookAdapter adapter = new PhoneBookAdapter(getActivity(), listPhoneBook);
        lvPhone.setAdapter(adapter);
        return v;

    }
}