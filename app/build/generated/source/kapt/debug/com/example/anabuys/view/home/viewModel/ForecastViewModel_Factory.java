package com.example.anabuys.view.home.viewModel;

import com.example.anabuys.network.ForecastRepository;
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
public final class ForecastViewModel_Factory implements Factory<ForecastViewModel> {
  private final Provider<ForecastRepository> repositoryProvider;

  public ForecastViewModel_Factory(Provider<ForecastRepository> repositoryProvider) {
    this.repositoryProvider = repositoryProvider;
  }

  @Override
  public ForecastViewModel get() {
    return newInstance(repositoryProvider.get());
  }

  public static ForecastViewModel_Factory create(Provider<ForecastRepository> repositoryProvider) {
    return new ForecastViewModel_Factory(repositoryProvider);
  }

  public static ForecastViewModel newInstance(ForecastRepository repository) {
    return new ForecastViewModel(repository);
  }
}
