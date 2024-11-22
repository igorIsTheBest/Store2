package com.example.store;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.fail;

import androidx.test.ext.junit.runners.AndroidJUnit4;

import com.example.store.data.room.StoreCardRepository;
import com.example.store.data.room.StoreCardEntity;
import com.example.store.data.room.StoreCardDAO;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;

import java.util.List;

@RunWith(AndroidJUnit4.class)
public class StoreCardRepositoryTest {

    private StoreCardRepository repository;

    @Before
    public void setUp() {
        StoreCardDAO mockDAO = Mockito.mock(StoreCardDAO.class);
        repository = new StoreCardRepository(mockDAO);
    }

    @Test
    public void testRepositoryInitialization() {
        Assert.assertNotNull("Repository should be initialized", repository);
    }

    @Test
    public void testRepositoryAddObject() {
        StoreCardEntity storeCard = new StoreCardEntity("Test Name", 30, "Test Address");
        repository.insertStoreCard(StoreCard, new StoreCardRepository.TaskCallback<Boolean>() {
            @Override
            public void onSuccess(Boolean result) {
                Assert.assertTrue("Insertion should succeed", result);
            }

            @Override
            public void onFailure(Exception e) {
                Assert.fail("Insertion should not fail");
            }
        });
    }

    @Test
    public void testRepositoryFetchObjects() {
        repository.getAllStoreCards(result -> {
            Assert.assertNotNull("Result should not be null", result);
            Assert.assertFalse("Result should not be empty", result.isEmpty());
        });
    }

    @Test
    public void testRepositoryAddNullObject() {
        repository.insertStoreCard(null, new StoreCardRepository.TaskCallback<Boolean>() {
            @Override
            public void onSuccess(Boolean result) {
                Assert.fail("Callback should not succeed for null insertion");
            }

            @Override
            public void onFailure(Exception e) {
                Assert.assertNotNull("Exception should be thrown", e);
            }
        });
    }
}
