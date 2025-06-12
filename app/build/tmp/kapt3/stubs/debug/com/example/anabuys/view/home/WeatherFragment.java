package com.example.anabuys.view.home;

@dagger.hilt.android.AndroidEntryPoint()
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u001c\u0010\u001b\u001a\u00020\u001c2\u0012\u0010\u001d\u001a\u000e\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u001c0\u001eH\u0002J$\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\"2\b\u0010#\u001a\u0004\u0018\u00010$2\b\u0010%\u001a\u0004\u0018\u00010&H\u0016J\b\u0010\'\u001a\u00020\u001cH\u0016J\b\u0010(\u001a\u00020\u001cH\u0002J\b\u0010)\u001a\u00020\u001cH\u0002J\b\u0010*\u001a\u00020\u001cH\u0002J\u0010\u0010+\u001a\u00020\u001c2\u0006\u0010,\u001a\u00020\u0015H\u0002J\u0010\u0010-\u001a\u00020\u001c2\u0006\u0010.\u001a\u00020/H\u0002R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\u00020\u00048BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007R\u000e\u0010\b\u001a\u00020\tX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001b\u0010\f\u001a\u00020\r8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0012\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00150\u00140\u0013X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001b\u0010\u0016\u001a\u00020\u00178BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u001a\u0010\u0011\u001a\u0004\b\u0018\u0010\u0019\u00a8\u00060"}, d2 = {"Lcom/example/anabuys/view/home/WeatherFragment;", "Landroidx/fragment/app/Fragment;", "()V", "_binding", "Lcom/example/anabuys/databinding/FragmentWeatherBinding;", "binding", "getBinding", "()Lcom/example/anabuys/databinding/FragmentWeatherBinding;", "communicator", "Lcom/example/anabuys/utils/FragmentCommunicator;", "forecastAdapter", "Lcom/example/anabuys/view/home/ForecastAdapter;", "forecastViewModel", "Lcom/example/anabuys/view/home/viewModel/ForecastViewModel;", "getForecastViewModel", "()Lcom/example/anabuys/view/home/viewModel/ForecastViewModel;", "forecastViewModel$delegate", "Lkotlin/Lazy;", "requestPermissionLauncher", "Landroidx/activity/result/ActivityResultLauncher;", "", "", "weatherViewModel", "Lcom/example/anabuys/view/home/viewModel/WeatherViewModel;", "getWeatherViewModel", "()Lcom/example/anabuys/view/home/viewModel/WeatherViewModel;", "weatherViewModel$delegate", "getUserLocation", "", "onLocationReady", "Lkotlin/Function1;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onDestroyView", "setupBottomNavigation", "setupObservers", "setupView", "showError", "message", "showWeatherInfo", "weather", "Lcom/example/anabuys/model/Weather;", "app_debug"})
public final class WeatherFragment extends androidx.fragment.app.Fragment {
    @org.jetbrains.annotations.Nullable()
    private com.example.anabuys.databinding.FragmentWeatherBinding _binding;
    @org.jetbrains.annotations.NotNull()
    private final kotlin.Lazy weatherViewModel$delegate = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlin.Lazy forecastViewModel$delegate = null;
    private com.example.anabuys.utils.FragmentCommunicator communicator;
    @org.jetbrains.annotations.NotNull()
    private final com.example.anabuys.view.home.ForecastAdapter forecastAdapter = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.activity.result.ActivityResultLauncher<java.lang.String[]> requestPermissionLauncher = null;
    
    public WeatherFragment() {
        super();
    }
    
    private final com.example.anabuys.databinding.FragmentWeatherBinding getBinding() {
        return null;
    }
    
    private final com.example.anabuys.view.home.viewModel.WeatherViewModel getWeatherViewModel() {
        return null;
    }
    
    private final com.example.anabuys.view.home.viewModel.ForecastViewModel getForecastViewModel() {
        return null;
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.NotNull()
    public android.view.View onCreateView(@org.jetbrains.annotations.NotNull()
    android.view.LayoutInflater inflater, @org.jetbrains.annotations.Nullable()
    android.view.ViewGroup container, @org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
        return null;
    }
    
    private final void setupView() {
    }
    
    private final void setupBottomNavigation() {
    }
    
    private final void getUserLocation(kotlin.jvm.functions.Function1<? super java.lang.String, kotlin.Unit> onLocationReady) {
    }
    
    private final void setupObservers() {
    }
    
    private final void showWeatherInfo(com.example.anabuys.model.Weather weather) {
    }
    
    private final void showError(java.lang.String message) {
    }
    
    @java.lang.Override()
    public void onDestroyView() {
    }
}