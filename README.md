# Navigation Components

Example Android application, written in Kotlin, to demonstrate use of navigation components from the Jetpack library

## Elements Covered
* Navigation host fragment
* Passing arguments between destinations
* Navigating to fragments and activites
* Custom callbacks for additional back press control

## Gradle Dependencies
```kotlin
apply plugin: 'androidx.navigation.safeargs'
```
```kotlin
def nav_version = "2.2.1"
implementation "androidx.navigation:navigation-fragment-ktx:$nav_version"
implementation "androidx.navigation:navigation-ui-ktx:$nav_version"
```

## Navigation Map
The map defines the start point (MainFragment) within the navigation host (MainActivity). The DisplayFragment destination includes an argument definition (colour - string) through which data can be passed in. DisplayActivity shows navigation to a new activity rather than fragment, whilst DisplayFragmentWithActionBar includes a custom callback for additional back press functionality
![screenshot](https://github.com/chrisc3456/navigation/blob/master/screenshot_navmap.png)

## Navigating to Fragments and Activities
```kotlin
private fun onClickNewActivity() {
    findNavController().navigate(MainFragmentDirections.actionMainFragmentToDisplayActivity())
}
```

## Navigating with Arguments
```kotlin
private fun onClickRed() {
    val action = MainFragmentDirections.actionMainFragmentToDisplayFragment()
    action.colour = "RED"
    findNavController().navigate(action)
}
```

## Reading Argument Values
```kotlin
override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    val colour = DisplayFragmentArgs.fromBundle(arguments!!).colour
    textViewArgValue.text = colour
}
```
