## Dolap.com study case
`MVVM + Clean` architecture applied.
`Dagger Hilt` used as a DI.
`:base` module added as a library that contains base classes such as BaseActivity, BaseViewModel and BaseComponent etc.
`https://www.mockable.io/` used for fake rest API.
`CircularCountDownView and ProductInfoView` created as reusable custom component.
`Loading, Error and Success states` handled in network layer(pls see `BaseNetworkUseCase.kt` and `BaseDisposableSingleObserver.kt`).
`unit tests` added.
