import android.util.Log;
import android.view.View;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.store.data.Shop;

import java.util.ArrayList;
import java.util.List;

public class MainActivityViewModel extends ViewModel {

    private final MutableLiveData<List<Shop>> listMutableLiveData;
    private final MutableLiveData<State> state;

    private final ShopRecyclerViewAdapter recyclerViewAdapter;

    private final ShopRepository shopRepository;

    public MainActivityViewModel(ShopRepository shopRepository) {
        this.shopRepository = shopRepository;
        this.listMutableLiveData = new MutableLiveData<>(new ArrayList<>());
        this.state = new MutableLiveData<>(new State());
        this.recyclerViewAdapter = new ShopRecyclerViewAdapter(MainActivityViewModel.this, listMutableLiveData.getValue());

        listMutableLiveData.observeForever(books -> {
            state.postValue(new State());
        });
    }

    public MutableLiveData<List<Shop>> getListMutableLiveData() {
        return listMutableLiveData;
    }

    public MutableLiveData<State> getState() {
        return state;
    }

    public ShopRecyclerViewAdapter getRecyclerViewAdapter() {
        return recyclerViewAdapter;
    }

    public void onRemoveClicked(Shop tmp) {
        Log.d("XXXX onRemove", tmp.toString());
    }

    public void onEditClicked(Shop tmp) {
        Log.d("XXXX onEditClicked", tmp.toString());
    }

    public void onNewBookClicked(View v) {
        State tmpState = state.getValue();
        tmpState.openNewShopActivity = true;
        state.postValue(tmpState);

    }

    public void reInitList() {
        shopRepository.getAllBooks((result, fault) -> {
            if (fault == null && result != null) {
                listMutableLiveData.postValue(result);
            }
        });
    }

    public class State {

        public boolean openNewBookActivity = false;

        public boolean isListEmpty() {
            return listMutableLiveData.getValue().isEmpty();
        }
    }
}
