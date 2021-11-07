# Porting guidelines

Exact process can vary between different mods. jere is a description of general process which should help you started:
1. Checkout any information in mod REAMDE/Wiki/Docs to find out if there are any special tasks/configs that need to be applied to the build
2. Fork original repository to preserve commit history
3. Apply build migration as explained in [migration guidlines](migration.md) on your fork
4. Try to get rid of dependencies on concrete jars (usually in the `lib` filder) if any present.
If they cannot be found in any maven repo, but are opensource - yyou can publishe them quite easiely.
Fork them and drop `jitpack.yml` frp, template in project root.
Mow jars will be accessible on `https://jitpack.io/` and can be added as a typical gradle dependency (same as your mod).
This way it will be much easier to change (upgrade/downgrade) your project dependencies, when needed.
5. Try to build the project and see check what types of errors are you getting. Generally there should be 2 types of errors you encounter:
   - Missing references to packages/classes/methods/fields/parameters. Things get renamed, moved, restructured, removed or even not yet exist. That's the straightforward part - you'll need to adjust references and way things are invoked. 
    In case of missing things youll either need to implement something that's imitates missing parts or resign from some functionality
   - Build related errors (e.g. something that is a part of the mod in never versions previously was a external library - you'll need to add it as a dependencies)
6. Fix all build related errors (so build system won't get in your way)
7. Fix remaining errors. Good approach is to start working with smaller things first, building up your confidence in how the mod works and gradually approaching more complex stuff, here is a general algorithm:
   1. Begin with fixing moved/renamed things by deleting all bad imports and with help of the IDE reimport equivalents if present. 
      Intelij IDEA you has setting for unumbiguos autoimport and import optimisation on the fly, which can greatly speedup the process. just pay attention to what it's actually imported.  
   2. Remove all unworking code which is not easlily fixable (e.g. class is not defined in forge) and provide stubs in it's place (e.g. replacing reference to non existing classes with your class with empty methods).
      Do not forget to track all things you've stubbed, if you are working on port alone - TODOs should be sufficient (most IDEs have build in TODO browser).
   3. Build the project and attempt to run it
   4. If there were any critical errors which cause minecraft to crash or mod to not work - try fixing them first, so you can test your changes
   5. Start fixing small things, ones that you think you have most chances to fix and work your way up
   6. If any there is any feature that is not worf it's time or you simply don't know how to do it - leave it and open an issue in your repository where you'll explain your findings and blockers.
   7. Maybe somebody with greater knowledge and motivated enough will try to take bite at it.
9. Fix bugs you've introduced when porting. 
  It's is uncommon for mods to have lots of workarounds and hidden connections.
  You'll need to test things and check if they work as intended (gl;hf ;p)

Good luck porting it! It's better be worth it!
