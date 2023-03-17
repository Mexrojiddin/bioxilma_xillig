package uz.mexboy.vokall.ui.mundarija;

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
import uz.mexboy.vokall.MainActivity;
import uz.mexboy.vokall.R;
import uz.mexboy.vokall.adapter.MundarijaAdapter;
import uz.mexboy.vokall.model.MundarijaModel;
import uz.mexboy.vokall.ui.home.HomeFragment;

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
        data.add(new MundarijaModel("Bosh sahifa", 0));
        data.add(new MundarijaModel("Kirish", 2));
        data.add(new MundarijaModel("O’quv fanning dolzarbligi va oliy kasbiy ta’limdagi o’rni ", 3));
        data.add(new MundarijaModel("O’quv fanining maqsadi va vazifalari", 3));
        data.add(new MundarijaModel("O’zbekistonda musiqa madaniyatini shakllanishi jarayonlari", 5));
        data.add(new MundarijaModel("Musiqada yangicha uslub", 9));
        data.add(new MundarijaModel("Musiqa madaniyatini rivojida milliy cholg’ularning o’rni va\n" +
                "ahamiyati", 13));
        data.add(new MundarijaModel("O’zbek musiqa madaniyati namoyandalari ", 15));
        data.add(new MundarijaModel("Fanni o’qitishning maqsad vazifalari", 64));
        data.add(new MundarijaModel("Qo’shiq – aytim tushunchasi va uning inson hayotidagi o’rni", 66));
        data.add(new MundarijaModel("O’zbek xalq qo’shiq ijrochiligi hamd xonandalik ijrochiligi tarixi", 68));
        data.add(new MundarijaModel("Vokal va zamonaviy musiqa xonandaligi to’g’risidagi asosiy\n" +
                "tushunchalar", 71));
        data.add(new MundarijaModel("Xonandalik san’ati mahorati", 76));
        data.add(new MundarijaModel("Ovoz imkoniyatlari, uning gigienasi va talqini bilan bog’liq\n" +
                "qonuniyatlar", 83));
        data.add(new MundarijaModel("Matn va talaffuz masalalari", 89));
        data.add(new MundarijaModel("So‘z va ohang", 92));
        data.add(new MundarijaModel("Xonandaning ovoz tuzishi tavsifi", 95));
        data.add(new MundarijaModel("Erkaklar ovozi registrlari", 96));
        data.add(new MundarijaModel("Ayollar ovozi registrlari", 96));
        data.add(new MundarijaModel("Ovoz tayanchi", 97));
        data.add(new MundarijaModel("Kuylayotganda lab, til va yumshoq tanglay ish faoliyati ", 105));
        data.add(new MundarijaModel("Xonandaning nutqi", 108));
        data.add(new MundarijaModel("Ovoz tarbiyalashning fonetik uslubi", 109));
        data.add(new MundarijaModel("Xonandaning hayot tarzi", 113));
        data.add(new MundarijaModel("Ta’limda ketma - ketlik va uzluksizlik tamoyili", 114));
        data.add(new MundarijaModel("Talaba tovushiga o’qituvchining ta’sir etish usullari", 116));
        data.add(new MundarijaModel("Xonandalik ovozini aniqlash", 118));
        data.add(new MundarijaModel("Xonandalik registrlari", 119));
        data.add(new MundarijaModel("Ataka turlari", 126));
        data.add(new MundarijaModel("Kuylash va uning xususiyatlari ", 128));
        data.add(new MundarijaModel("Kuylashni boshlash (xirgoyi) ", 141));
        data.add(new MundarijaModel("Registrlarni silliqlash", 142));
        data.add(new MundarijaModel("Artikulyasiya. Diksiya", 143));
        data.add(new MundarijaModel("Fililash ovoz harakatchanligini rivojlantirish ", 145));
        data.add(new MundarijaModel("Musiqa asarlar tahlili ", 147));
        data.add(new MundarijaModel("Musiqada janr va uslub tushunchasi ", 149));
        data.add(new MundarijaModel("Kuy – ohang ", 150));
        data.add(new MundarijaModel("Metr va ritm", 150));
        data.add(new MundarijaModel("«Vokal va zamonaviy musiqa» fani laboratoriya mashg’ulotlari\n" +
                "mavzulari bo’yicha taxminiy repertuarlar ", 154));
        data.add(new MundarijaModel("Lug’at. (Musiqiy atamalar)", 254));
        data.add(new MundarijaModel("Foydalangan adabiyotlar ro’yxati", 261));





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