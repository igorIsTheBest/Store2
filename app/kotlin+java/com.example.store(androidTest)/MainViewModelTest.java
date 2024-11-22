package com.example.store;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertEquals;

import androidx.arch.core.executor.testing.InstantTaskExecutorRule;
import androidx.lifecycle.LiveData;
import androidx.test.ext.junit.runners.AndroidJUnit4;

import com.example.store.viewmodel.MainViewModel;
import com.example.store.data.room.StoreCardRepository;
import com.example.store.data.room.StoreCardEntity;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;

@RunWith(AndroidJUnit4.class)
public class MainViewModelTest {

    @Rule
    public InstantTaskExecutorRule instantTaskExecutorRule = new InstantTaskExecutorRule();

    private MainViewModel viewModel;
    private StoreCardRepository mockRepository;

    @Before
    public void setUp() {
        mockRepository = Mockito.mock(StoreCardRepository.class);
        viewModel = new MainViewModel(mockRepository);
    }

    @Test
    public void testViewModelInitialization() {
        Assert.assertNotNull("ViewModel should be initialized", viewModel);
    }

    @Test
    public void testViewModelGetLiveDataForRecyclerView() {

        List<StoreCardEntity> mockData = new ArrayList<>();
        mockData.add(new StoreCardEntity("Test Store", 30, "Test Address"));

        Mockito.doAnswer(invocation -> {
            ((StoreCardRepository.ResultCallback<List<StoreCardEntity>>) invocation.getArguments()[0]).onResult(mockData);
            return null;
        }).when(mockRepository).getAllStoreCards(Mockito.any());

        viewModel.reinitializeStoreCardList();

        viewModel.getAllStoreCards().observeForever(allCards -> {
            Assert.assertNotNull("LiveData should not be null", allCards);
            assertEquals("LiveData should contain one entry", 1, allCards.size());
        });
    }

    @Test
    public void testViewModelGetLiveDataForViewState() {

        Mockito.doAnswer(invocation -> {
            ((StoreCardRepository.TaskCallback<Boolean>) invocation.getArguments()[1]).onSuccess(true);
            return null;
        }).when(mockRepository).insertStoreCard(Mockito.any(), Mockito.any());

        viewModel.insertMedicalCard(new StoreCardEntity("Test Store", 30, "Test Address"));

        LiveData<Boolean> liveData = viewModel.getInsertionSuccess();
        Assert.assertNotNull("Insertion success LiveData should not be null", liveData.getValue());
        assertEquals("Insertion should be successful", true, liveData.getValue());
    }

    @Test
    public void testViewModelRecyclerViewAdapter() {
        List<StoreCardEntity> cards = new ArrayList<>();
        cards.add(new StoreCardEntity("Test", 25, "Test Address"));

        Mockito.doAnswer(invocation -> {
            ((StoreCardRepository.ResultCallback<List<MedicalCardEntity>>) invocation.getArguments()[0]).onResult(cards);
            return null;
        }).when(mockRepository).getAllMedicalCards(Mockito.any());

        viewModel.reinitializeMedicalCardList();

        viewModel.getAllStoreCards().observeForever(allCards -> {
            assertEquals("RecyclerView should display correct item count", cards.size(), allCards.size());
        });
    }

    @Test
    public void testViewModelReinitializeRecyclerViewList() {
        // Симуляція оновлених даних
        List<StoreCardEntity> newMockData = new ArrayList<>();
        newMockData.add(new StoreCardEntity("New Test Name", 40, "New Test Address"));

        Mockito.doAnswer(invocation -> {
            ((StoreCardRepository.ResultCallback<List<StoreCardEntity>>) invocation.getArguments()[0]).onResult(newMockData);
            return null;
        }).when(mockRepository).getAllMedicalCards(Mockito.any());

        // Викликаємо метод реініціалізації
        viewModel.reinitializeMedicalCardList();

        // Перевіряємо, що LiveData оновилося новими даними
        viewModel.getAllStoreCards().observeForever(cards -> {
            Assert.assertNotNull("List should not be null after reinitialization", cards);
            assertEquals("List should contain updated data", newMockData.size(), cards.size());
        });
    }
}
