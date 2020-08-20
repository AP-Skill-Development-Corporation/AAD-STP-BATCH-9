package com.example.cherry.examplerdb.Database;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

public class RViewModel extends AndroidViewModel {
    RRepository rRepository;
    LiveData<List<RTable>> list;
    public RViewModel(@NonNull Application application) {
        super(application);
        rRepository = new RRepository(application);
        list = rRepository.readAllData();
    }
    /*This is for insert method*/
    public void insert(RTable rTable){
        rRepository.insert(rTable);
    }
    /*This is for reading the data*/
    public LiveData<List<RTable>> readData(){
        return list;
    }
    /*This  is for delete method*/
    public void delete(RTable rTable){
        rRepository.delete(rTable);
    }
    /*This is for update method*/
    public void update(RTable rTable){
        rRepository.update(rTable);
    }
}
