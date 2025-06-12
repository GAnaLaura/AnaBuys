package com.example.anabuys.network;

import com.example.anabuys.core.WeatherAPI;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Provider;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.annotation.processing.Generated;

@ScopeMetadata
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
public final class WeatherRepository_Factory implements Factory<WeatherRepository> {
  private final Provider<WeatherAPI> weatherAPIProvider;

  public WeatherRepository_Factory(Provider<WeatherAPI> weatherAPIProvider) {
    this.weatherAPIProvider = weatherAPIProvider;
  }

  @Override
  public WeatherRepository get() {
    return newInstance(weatherAPIProvider.get());
  }

  public static WeatherRepository_Factory create(Provider<WeatherAPI> weatherAPIProvider) {
    return new WeatherRepository_Factory(weatherAPIProvider);
  }

  public static WeatherRepository newInstance(WeatherAPI weatherAPI) {
    return new WeatherRepository(weatherAPI);
  }
}
