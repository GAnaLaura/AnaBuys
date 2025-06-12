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
public final class RetrofitInstance_ProvideForecastAPIFactory implements Factory<ForecastAPI> {
  private final Provider<Retrofit> retrofitProvider;

  public RetrofitInstance_ProvideForecastAPIFactory(Provider<Retrofit> retrofitProvider) {
    this.retrofitProvider = retrofitProvider;
  }

  @Override
  public ForecastAPI get() {
    return provideForecastAPI(retrofitProvider.get());
  }

  public static RetrofitInstance_ProvideForecastAPIFactory create(
      Provider<Retrofit> retrofitProvider) {
    return new RetrofitInstance_ProvideForecastAPIFactory(retrofitProvider);
  }

  public static ForecastAPI provideForecastAPI(Retrofit retrofit) {
    return Preconditions.checkNotNullFromProvides(RetrofitInstance.INSTANCE.provideForecastAPI(retrofit));
  }
}
