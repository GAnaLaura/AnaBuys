package com.example.anabuys.network;

import com.example.anabuys.core.ForecastAPI;
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
public final class ForecastRepository_Factory implements Factory<ForecastRepository> {
  private final Provider<ForecastAPI> forecastAPIProvider;

  public ForecastRepository_Factory(Provider<ForecastAPI> forecastAPIProvider) {
    this.forecastAPIProvider = forecastAPIProvider;
  }

  @Override
  public ForecastRepository get() {
    return newInstance(forecastAPIProvider.get());
  }

  public static ForecastRepository_Factory create(Provider<ForecastAPI> forecastAPIProvider) {
    return new ForecastRepository_Factory(forecastAPIProvider);
  }

  public static ForecastRepository newInstance(ForecastAPI forecastAPI) {
    return new ForecastRepository(forecastAPI);
  }
}
