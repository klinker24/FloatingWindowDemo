FloatingWindowDemo
==================

![Alt text](/screenshots/screen1.png "Screen 1") ![Alt text](/screenshots/screen2.png "Screen 2")

XDA Guide: http://forum.xda-developers.com/showthread.php?p=46569392#post46569392

Play Store Demo: https://play.google.com/store/apps/details?id=com.klinker.android.floating_window&hl=en

This is just a demo of how to create a floating window activity such as Paranoid Android's Halo is able to do.

It is actually a very simple process. The way me and Jacob Klinker do it for our apps is by extending the MainActivity in some kind of popup activity, setting the theme to one of androids .Dialog themes, then using the built in window manager to set the size of the window.

If you want everything in the window to work the same as in the MainActivity, then you are done after making the setUpWindow function, otherwise, if you just do all of your work in seperate functions from the onCreate method, it is very easy to override them and change their behavior in the floating window form.

This is just a very simple demo, with a button to change between states and an edit text to see how the window is able to resize. That is it, no bells or whistles, but, in theory, this pop up can do EVERYTHING and ANYTHING that your MainActivity can do. You will just have to override the correct functionality and make sure you initialize and monitor everything correctly.

This doens't just have to be for a stand alone pop up though, say you wanted to be different and have your settings menu come up in windowed form instead of as a new activity. You could just not finish() the current activity and call the settings menu with a new intent. That may be a silly example, but you see the idea, windows stacking on top of each other can be very useful and faster since there doesn't have to be any transitions or new brand new activities.

Obviously this is very basic, as I said. It is the framework for building awesome stuff though. For me and Jacob's Sliding Messaging Pro app, we use it as the quick replay and make it availible from a "SlideOver" bubble, a lot like halo does. As long as you can find a clever way to call this activity though, it is like the entire app is availible anywhere in the system, that is what made PA's implementation to new and great!

Hope you enjoy this, a lot of very powerful stuff can come from a floating window implementation like this!

Credit goes to Paranoid Android for the idea, then Jacob Klinker and I for the implementation and method

-- Luke Klinker
