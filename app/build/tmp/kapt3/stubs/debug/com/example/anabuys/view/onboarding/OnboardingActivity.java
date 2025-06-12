package com.example.anabuys.view.onboarding;

@dagger.hilt.android.AndroidEntryPoint()
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002B\u0005\u00a2\u0006\u0002\u0010\u0003J\u0012\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0014J\u000e\u0010\n\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\fJ\u0010\u0010\r\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\u000fH\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082.\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0010"}, d2 = {"Lcom/example/anabuys/view/onboarding/OnboardingActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "Lcom/example/anabuys/utils/FragmentCommunicator;", "()V", "binding", "Lcom/example/anabuys/databinding/ActivityOnboardingBinding;", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "showError", "message", "", "showLoader", "value", "", "app_debug"})
public final class OnboardingActivity extends androidx.appcompat.app.AppCompatActivity implements com.example.anabuys.utils.FragmentCommunicator {
    private com.example.anabuys.databinding.ActivityOnboardingBinding binding;
    
    public OnboardingActivity() {
        super();
    }
    
    @java.lang.Override()
    protected void onCreate(@org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
    }
    
    @java.lang.Override()
    public void showLoader(boolean value) {
    }
    
    /**
     * Muestra un mensaje de error al usuario usando un Toast.
     * Puedes cambiar esto por un Snackbar o una vista personalizada si lo prefieres.
     */
    public final void showError(@org.jetbrains.annotations.NotNull()
    java.lang.String message) {
    }
}