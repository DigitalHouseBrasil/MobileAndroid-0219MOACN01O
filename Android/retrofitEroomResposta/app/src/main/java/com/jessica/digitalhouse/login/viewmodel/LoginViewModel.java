package com.jessica.digitalhouse.login.viewmodel;

import android.app.Application;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.annotation.NonNull;

import android.content.Intent;
import android.util.Log;

import com.google.android.material.snackbar.Snackbar;
import com.google.firebase.auth.FirebaseAuth;
import com.jessica.digitalhouse.home.view.MainActivity;
import com.jessica.digitalhouse.model.Movie;
import com.jessica.digitalhouse.model.Result;

import org.reactivestreams.Subscription;

import java.util.List;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

import static com.jessica.digitalhouse.database.Database.getDatabase;
import static com.jessica.digitalhouse.network.RetrofitService.getApiService;

public class LoginViewModel extends AndroidViewModel {
    private MutableLiveData<Boolean> isLogged = new MutableLiveData<>();
    private MutableLiveData<Throwable> liveDataError = new MutableLiveData<>();
    private MutableLiveData<Boolean> isLoading = new MutableLiveData<>();
    private CompositeDisposable disposable = new CompositeDisposable();

    public LoginViewModel(@NonNull Application application) {
        super(application);
    }

    @Override
    protected void onCleared() {
        super.onCleared();
        disposable.clear();
    }

    public void login(String email, String password) {
        // seta o loading para true para dar feedback ao uauário, que começou o login
        isLoading.setValue(true);

        FirebaseAuth firebaseAuth = FirebaseAuth.getInstance();
        // tentamos fazer o login com o email e senha no firebase
        firebaseAuth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener(task -> {

                    // seta o loading para true para dar feedback ao uauário, qeu terminou o login
                    isLoading.setValue(false);

                    // Caso login com sucesso vamos para tela  Home
                    if (task.isSuccessful()) {
                        isLogged.setValue(true);
                    } else {
                        // Se deu algum erro mostramos para o usuário a mensagem
                        liveDataError.setValue(task.getException());
                    }
                });
    }

    public LiveData<Boolean> getIsLogged() {
        return isLogged;
    }

    public LiveData<Throwable> getLiveDataError() {
        return liveDataError;
    }

    public LiveData<Boolean> getIsLoading() {
        return isLoading;
    }
}
