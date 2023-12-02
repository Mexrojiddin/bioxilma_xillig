package uz.mexboy.bioxilma_xillig.ui.mundarija;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;
;
import uz.mexboy.bioxilma_xillig.MainActivity;
import uz.mexboy.bioxilma_xillig.R;
import uz.mexboy.bioxilma_xillig.adapter.MundarijaAdapter;
import uz.mexboy.bioxilma_xillig.model.MundarijaModel;
import uz.mexboy.bioxilma_xillig.ui.home.HomeFragment;

public class MundarijaFragment extends Fragment implements MundarijaAdapter.ItemClickListener {
    private Context mContext;
    private View root;
    private List<MundarijaModel> data;

    private RecyclerView recyclerView;

    private MundarijaAdapter mundarijaAdapter;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        root = inflater.inflate(R.layout.fragment_mundarija, container, false);

        init();
        return root;
    }

    private void init() {
        data = new ArrayList<>();
        data.add(new MundarijaModel("Kirish", 2));
        data.add(new MundarijaModel("Andijon urbanoflorasining (Bogʻishamol dahasi hududi) taksonomik tarkib", 4));
        data.add(new MundarijaModel("Taqiqot hududining noyob, endemik va muhofazaga muhtoj turlari", 6));
        data.add(new MundarijaModel("Muhofazaga muhtoj turlarning biotoplari, populyatsiyalari va saqlashga\n" +
                "oid tavsiyalar", 12));
        data.add(new MundarijaModel("Muhofazaga muhtoj ayrim turlarni bioiqlimiy modellashtirish", 15));
        data.add(new MundarijaModel("Foydalanilgan adabiyotlar roʻyxati", 20));



        recyclerView = root.findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(mContext));

        mundarijaAdapter = new MundarijaAdapter(mContext, data);
        mundarijaAdapter.setClickListener(this);
        recyclerView.setAdapter(mundarijaAdapter);

    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        mContext = context;
    }

    @Override
    public void onItemClick(View view, int position) {
        MainActivity.defaultPage = data.get(position).getPage();

        MainActivity.toolbar.setTitle("Bosh sahifa");
        getActivity().getSupportFragmentManager().beginTransaction().
                replace(R.id.nav_host_fragment,
                        new HomeFragment())

                .commit();

        getActivity().getSupportFragmentManager().popBackStackImmediate();

        MainActivity.navPage = R.id.nav_home;


    }
}