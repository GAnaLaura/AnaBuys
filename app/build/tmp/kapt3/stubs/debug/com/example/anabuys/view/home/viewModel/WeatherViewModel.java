package com.example.anabuys.view.home.viewModel;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u000e\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00070\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0017\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00050\t8F\u00a2\u0006\u0006\u001a\u0004\b\n\u0010\u000bR\u000e\u0010\f\u001a\u00020\rX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0017\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00070\t8F\u00a2\u0006\u0006\u001a\u0004\b\u000f\u0010\u000b\u00a8\u0006\u0014"}, d2 = {"Lcom/example/anabuys/view/home/viewModel/WeatherViewModel;", "Landroidx/lifecycle/ViewModel;", "()V", "_loaderState", "Landroidx/lifecycle/MutableLiveData;", "", "_weatherInfo", "Lcom/example/anabuys/model/Weather;", "loaderState", "Landroidx/lifecycle/LiveData;", "getLoaderState", "()Landroidx/lifecycle/LiveData;", "repository", "Lcom/example/anabuys/network/WeatherRepository;", "weatherInfo", "getWeatherInfo", "getWeatherDetail", "", "coordinates", "", "app_debug"})
public final class WeatherViewModel extends androidx.lifecycle.ViewModel {
    @org.jetbrains.annotations.NotNull()
    private final com.example.anabuys.network.WeatherRepository repository = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.MutableLiveData<java.lang.Boolean> _loaderState = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.MutableLiveData<com.example.anabuys.model.Weather> _weatherInfo = null;
    
    public WeatherViewModel() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<java.lang.Boolean> getLoaderState() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<com.example.anabuys.model.Weather> getWeatherInfo() {
        return null;
    }
    
    public final void getWeatherDetail(@org.jetbrains.annotations.NotNull()
    java.lang.String coordinates) {
    }
}