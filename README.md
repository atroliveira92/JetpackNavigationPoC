# Jetpack navigation Prove of Concept
This is a PoC Project that consists in a atempt to implement a multi-module navigation using the Jetpack navigation library.  
The goal of this PoC is understand and apply a architecture that can support a navigation between feature modules without depends on each other.  
This project is a simple example of a architecture approach and is open to feedbacks and changes.

# Modules
 - app: App module with a simple `MainActity` that works as a shell host to the feature's Fragments. Also, this module configure the DI framework 
 - entities: Provide common data class entities, such as in this project the `User` entity class
 - common: It contains the libraries depencies for navigation and also the navigation router contracts to each module
 - features:
    - home: Simple fragment that can navigate to `:profile` module or `:settings` module
    - profile: Simple fragment that can navigate to `:creditcard` module
    - creditcard: Two fragments that can navigate to each other and owns their own navigation graph. `CreditCardFragment` is a example of parcelable navigation expecting an `User` object as parameter
    - settings: Example of a module that has their own Activity and navigation graph internally. This is a example that does not use the `NavController` and just uses a regular `startActivity`

# Module depency graph
![Image starts with a box called app pointing with arrows to 4 other boxes called feature home, feature settings, feature profile and feature credit card. The 4 boxes are pointing with arrows to a box called commons. The boxes called commons, feature profile and feature credit card are also pointing to a box called entities](/images/poc_module_diagram.jpg)
# Libraries used
 - koin: Dependency Injection
 - AndroidX Navigation: Screen navigation
 
 # Navigation usage
 In order to create a feature that can be navigate by others use the following steps:
  - Create a navigation contract inside `:commons/navigation/router`. E.g:
```kotlin
interface CreditCardRouter {
    fun navigate(user: User, navController: NavController)
}
```
 - In your feature module, implement the contract and how the module will handle the navigation. E.g:
 ```kotlin
class CreditCardRouterImpl: CreditCardRouter {
    override fun navigate(user: User, navController: NavController) {
        navController.navigate(R.id.nav_graph_credit_card, bundleOf("user" to user))
    }
}
```
 - Register the navigation implementation in the DI framework `Module class`. E.g:
 ```kotlin
 val creditCardModule = module {
    single<CreditCardRouter>{ CreditCardRouterImpl() }
}
```
 - Inside `:app` module, register the feature module in the `AppModule` class in order to include it in the DI framework
 - If the feature module fragments will be host by the `:app/MainActivity`, so include the feature navigation graph into `main_nav_graph.xml` file. E.g:
 ```xml
 <include app:graph="@navigation/nav_graph_credit_card"/>
 ```
To navigate to a module, just get the contract by the DI injection and use as the following example:
```kotlin
private val creditCardRouter by inject<CreditCardRouter>()

creditCardRouter.navigate(User("1", "UserName"), findNavController())
```

# Improvements
 - The `:commons/navigation/router` contracts could extends a upper interface/abstract class. This way we could let the navigation generic, impose the name `navigate` for the implemented methods and it could be easier to test
 - Create a deeplink layer in `:commons/navigation` with could work with a Adapter pattern in order to load from any source a correct entity. E.g: Parse a id from deeplink that will load a User entity
 - Should we use a `:entities` module? As the project grown the numbers of entities that will be group in this module can be big
 - Implement a [dyanmic feature module](https://developer.android.com/guide/playcore/feature-delivery) example
