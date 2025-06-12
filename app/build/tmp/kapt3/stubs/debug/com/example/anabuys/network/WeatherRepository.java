package com.example.anabuys.network;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0086@\u00a2\u0006\u0002\u0010\tR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\n"}, d2 = {"Lcom/example/anabuys/network/WeatherRepository;", "", "weatherAPI", "Lcom/example/anabuys/core/WeatherAPI;", "(Lcom/example/anabuys/core/WeatherAPI;)V", "getCurrentWeather", "Lcom/example/anabuys/model/Weather;", "coordinates", "", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_debug"})
public final class WeatherRepository {
    @org.jetbrains.annotations.NotNull()
    private final com.example.anabuys.core.WeatherAPI weatherAPI = null;
    
    @javax.inject.Inject()
    public WeatherRepository(@org.jetbrains.annotations.NotNull()
    com.example.anabuys.core.WeatherAPI weatherAPI) {
        super();
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object getCurrentWeather(@org.jetbrains.annotations.NotNull()
    java.lang.String coordinates, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.example.anabuys.model.Weather> $completion) {
        return null;
    }
}