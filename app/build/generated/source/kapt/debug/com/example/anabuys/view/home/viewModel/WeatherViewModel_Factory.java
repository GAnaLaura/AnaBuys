package com.example.anabuys.view.home.viewModel;

import com.example.anabuys.network.WeatherRepository;
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
public final class WeatherViewModel_Factory implements Factory<WeatherViewModel> {
  private final Provider<WeatherRepository> repositoryProvider;

  public WeatherViewModel_Factory(Provider<WeatherRepository> repositoryProvider) {
    this.repositoryProvider = repositoryProvider;
  }

  @Override
  public WeatherViewModel get() {
    return newInstance(repositoryProvider.get());
  }

  public static WeatherViewModel_Factory create(Provider<WeatherRepository> repositoryProvider) {
    return new WeatherViewModel_Factory(repositoryProvider);
  }

  public static WeatherViewModel newInstance(WeatherRepository repository) {
    return new WeatherViewModel(repository);
  }
}
