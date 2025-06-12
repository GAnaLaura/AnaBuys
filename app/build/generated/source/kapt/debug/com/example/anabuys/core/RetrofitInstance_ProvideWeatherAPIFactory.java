package com.example.anabuys.core;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.Provider;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.annotation.processing.Generated;
import retrofit2.Retrofit;

@ScopeMetadata("javax.inject.Singleton")
@QualifierMetadata
@DaggerGenerated
@Generated(
    value = "dagger.internal.codegen.ComponentProcessor",
    comments = "https://dagger.dev"
)
@SuppressWarnings({
    "unchecked",
    "rawtypes",
    "KotlinInternal",
    "KotlinInternalInJava",
    "cast",
    "deprecation",
    "nullness:initialization.field.uninitialized"
})
public final class RetrofitInstance_ProvideWeatherAPIFactory implements Factory<WeatherAPI> {
  private final Provider<Retrofit> retrofitProvider;

  public RetrofitInstance_ProvideWeatherAPIFactory(Provider<Retrofit> retrofitProvider) {
    this.retrofitProvider = retrofitProvider;
  }

  @Override
  public WeatherAPI get() {
    return provideWeatherAPI(retrofitProvider.get());
  }

  public static RetrofitInstance_ProvideWeatherAPIFactory create(
      Provider<Retrofit> retrofitProvider) {
    return new RetrofitInstance_ProvideWeatherAPIFactory(retrofitProvider);
  }

  public static WeatherAPI provideWeatherAPI(Retrofit retrofit) {
    return Preconditions.checkNotNullFromProvides(RetrofitInstance.INSTANCE.provideWeatherAPI(retrofit));
  }
}
