package com.example.anabuys.network;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J,\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b2\u0006\u0010\n\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u0006H\u0086@\u00a2\u0006\u0002\u0010\u000eR\u000e\u0010\u0005\u001a\u00020\u0006X\u0082D\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u000f"}, d2 = {"Lcom/example/anabuys/network/ForecastRepository;", "", "forecastAPI", "Lcom/example/anabuys/core/ForecastAPI;", "(Lcom/example/anabuys/core/ForecastAPI;)V", "apiKey", "", "getForecast", "Lretrofit2/Response;", "Lokhttp3/ResponseBody;", "location", "days", "", "lang", "(Ljava/lang/String;ILjava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_debug"})
public final class ForecastRepository {
    @org.jetbrains.annotations.NotNull()
    private final com.example.anabuys.core.ForecastAPI forecastAPI = null;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String apiKey = "663fbc04a6734f6996f162241251006";
    
    @javax.inject.Inject()
    public ForecastRepository(@org.jetbrains.annotations.NotNull()
    com.example.anabuys.core.ForecastAPI forecastAPI) {
        super();
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object getForecast(@org.jetbrains.annotations.NotNull()
    java.lang.String location, int days, @org.jetbrains.annotations.NotNull()
    java.lang.String lang, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super retrofit2.Response<okhttp3.ResponseBody>> $completion) {
        return null;
    }
}