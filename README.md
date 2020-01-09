![UI Testing for Beginners](https://codingwithmitch.s3.amazonaws.com/static/ui-testing-for-beginners/images/UI_Testing_with_Espresso_and_androidx.test.png "UI Testing with Espresso and androidx.test")

# [UI Testing for Beginners](https://codingwithmitch.com/courses/ui-testing-for-beginners/)
Watch the video course here (**FREE**): [UI Testing for Beginners](https://codingwithmitch.com/courses/ui-testing-for-beginners/)

### Espresso Samples:
#### [Activities in Isolation](https://github.com/mitchtabian/EspressoUITest-Examples/tree/simple-activity)
1. ActivityScenario vs ActivityScenarioRule
2. Matching with text in view

#### [Activity Navigation](https://github.com/mitchtabian/EspressoUITest-Examples/tree/activity-navigation)
1. Basic activity navigation testing

#### [Test Suites](https://github.com/mitchtabian/EspressoUITest-Examples/tree/test-suites)
1. Creating test suites to run multiple test classes at once

#### [Fragments in Isolation (simple)](https://github.com/mitchtabian/EspressoUITest-Examples/tree/fragments-in-isolation)
1. Simple use case testing the fragments and their behavior with no dependencies

#### [Fragments in Isolation (with Mockk & FragmentFactory Dependencies)](https://github.com/mitchtabian/EspressoUITest-Examples/tree/simple-mocking-dependencies)
1. Testing kotlin final classes (making them open for testing)
2. More complex tests and why dependency injection is recommended
3. Providing dependencies with a FragmentFactory

#### [Fragments Navigation](https://github.com/mitchtabian/EspressoUITest-Examples/tree/fragment-navigation)
1. Ensuring correct fragment is in view after any particular action is taken.

#### [Intents (image from gallery)](https://github.com/mitchtabian/EspressoUITest-Examples/tree/intents-gallery-example)
1. Selecting an image from android device gallery and confirming the correct one is received by onActivityResult
2. IntentsTestRule
3. Custom Image Matcher

#### [Intents (image from camera)](https://github.com/mitchtabian/EspressoUITest-Examples/tree/intents-camera-example)
1. Taking a new image with camera and confirming the correct one is received by onActivityResult
2. IntentsTestRule
3. Custom Image Matcher

#### [Dialog (detecting if visible)](https://github.com/mitchtabian/EspressoUITest-Examples/tree/simple-dialog)
1. Material Dialogs
2. Showing a dialog and confirming it is in view
3. Dismissing a dialog and confirming it is out of view

#### [Dialog (capture input)](https://github.com/mitchtabian/EspressoUITest-Examples/tree/dialog-capture-input)
1. Material Dialogs
2. Capturing input from dialog and passing to fragment

#### [Toasts (custom Toast Matcher)](https://github.com/mitchtabian/EspressoUITest-Examples/tree/simple-toast)
1. Confirming a toast is showing using a Custom Toast Matcher

#### [RecyclerView](https://github.com/mitchtabian/EspressoUITest-Examples/tree/simple-recyclerview)
1. Confirming correct data in RecyclerView
2. Clicking list items
3. Navigating to different fragments when list item is clicked
4. Back navigation testing
