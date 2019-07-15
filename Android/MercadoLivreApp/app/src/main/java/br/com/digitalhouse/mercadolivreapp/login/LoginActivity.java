package br.com.digitalhouse.mercadolivreapp.login;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.GraphRequest;
import com.facebook.login.LoginManager;
import com.facebook.login.LoginResult;
import com.facebook.login.widget.LoginButton;
import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.SignInButton;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.tasks.Task;

import java.util.Arrays;

import br.com.digitalhouse.mercadolivreapp.MainActivity;
import br.com.digitalhouse.mercadolivreapp.R;

public class LoginActivity extends AppCompatActivity {
    private Button btnLoginGoogle;
    private Button btnLoginFacebook;
    private LoginButton btnLoginFacebookDefault;
    private SignInButton btnLoginGoogleDefault;
    private GoogleSignInClient googleSignInClient;
    private CallbackManager callbackManager;

    private static final int RC_SIGN_IN = 200;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        btnLoginGoogle = findViewById(R.id.btnLoginGoogle);
        btnLoginGoogleDefault = findViewById(R.id.btnLoginGoogleDefault);
        btnLoginFacebook = findViewById(R.id.btnLoginFacebook);
        btnLoginFacebookDefault = findViewById(R.id.btnLoginFacebookDefault);

        btnLoginGoogle.setOnClickListener(v -> {
            loginGoogle();
        });

        btnLoginGoogleDefault.setSize(SignInButton.SIZE_WIDE);
        btnLoginGoogleDefault.setOnClickListener(v -> {
            loginGoogle();
        });


        btnLoginFacebook.setOnClickListener(v -> {
            LoginManager.getInstance().logInWithReadPermissions(this, Arrays.asList("email", "public_profile"));
        });

        loginFacebook();
    }

    private void loginFacebook() {
        callbackManager = CallbackManager.Factory.create();
        btnLoginFacebookDefault.setPermissions(Arrays.asList("email", "public_profile"));

        btnLoginFacebookDefault.registerCallback(callbackManager, new FacebookCallback<LoginResult>() {
            @Override
            public void onSuccess(LoginResult loginResult) {
                Log.w("TAG", "facebook: success: user");
                getFacebookUserProfile(loginResult);
            }

            @Override
            public void onCancel() {
                Log.w("TAG", "facebook: cancelado");
            }

            @Override
            public void onError(FacebookException exception) {
                Log.w("TAG", "facebook: error=" + exception.getMessage());
            }
        });
    }

    private void loginGoogle() {
        GoogleSignInOptions gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestEmail()
                .build();

        googleSignInClient = GoogleSignIn.getClient(this, gso);

        Intent signInIntent = googleSignInClient.getSignInIntent();
        startActivityForResult(signInIntent, RC_SIGN_IN);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == RC_SIGN_IN) {

            // The Task returned from this call is always completed, no need to attach
            // a listener.
            Task<GoogleSignInAccount> task = GoogleSignIn.getSignedInAccountFromIntent(data);

            try {
                GoogleSignInAccount account = task.getResult(ApiException.class);

                Log.w("TAG", "signInResult:success user=" + account.getDisplayName() + account.getEmail());
                gotoHome(account.getEmail());

            } catch (ApiException e) {
                Log.w("TAG", "signInResult:failed code=" + e.getStatusCode());
                e.printStackTrace();
            }
        } else {
            callbackManager.onActivityResult(requestCode, resultCode, data);
        }
    }

    private boolean verificaLogado() {
        return GoogleSignIn.getLastSignedInAccount(this) != null;
    }

    private void getFacebookUserProfile(LoginResult loginResult) {
        GraphRequest request = GraphRequest.newMeRequest(loginResult.getAccessToken(), (result, response) -> {
            try {
                Log.i("RESAULTS : ", result.toString());

                gotoHome(result.getString("email"));
            } catch (Exception e) {
                Log.e("TAG", "Erro ao buscar profile : ", e);
            }
        });

        Bundle parameters = new Bundle();
        parameters.putString("fields", "email");
        request.setParameters(parameters);
        request.executeAsync();
    }

    private void gotoHome(String email) {
        Intent intent = new Intent(LoginActivity.this, MainActivity.class);
        intent.putExtra("EMAIL", email);
        startActivity(intent);
        finish();
    }
}
