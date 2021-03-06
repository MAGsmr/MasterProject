package test3d;

import com.sun.j3d.exp.swing.JCanvas3D;
import com.sun.j3d.utils.behaviors.keyboard.KeyNavigatorBehavior;
import com.sun.j3d.utils.behaviors.mouse.MouseRotate;
import com.sun.j3d.utils.geometry.ColorCube;
import com.sun.j3d.utils.geometry.Sphere;
import com.sun.j3d.utils.universe.SimpleUniverse;

import javax.media.j3d.*;
import javax.vecmath.Color3f;
import javax.vecmath.Point3d;
import javax.vecmath.Vector3f;
import java.awt.*;

/**
 * Created by Анатолий on 02.04.2016.
 */
public class Hello3D {
    public Hello3D(){
        SimpleUniverse universe = new SimpleUniverse();

        BranchGroup group = new BranchGroup();

        group.addChild(new ColorCube(0.3));

        universe.getViewingPlatform().setNominalViewingTransform();

        universe.addBranchGraph(group);
    }

    public static void init(JCanvas3D canvas3D){
        BranchGroup group = new BranchGroup();
        Sphere sphere = new Sphere(0.5f);

        TransformGroup listenerGroup = new TransformGroup();
        listenerGroup.setCapability(TransformGroup.ALLOW_TRANSFORM_WRITE);
        listenerGroup.setCapability(TransformGroup.ALLOW_TRANSFORM_READ);
        group.addChild(listenerGroup);

        //KeyNavigatorBehavior behaviour = new KeyNavigatorBehavior(listenerGroup);
        MouseRotate behaviour = new MouseRotate(canvas3D, listenerGroup);
        behaviour.setSchedulingBounds(new BoundingSphere(new Point3d(), 100));

        listenerGroup.addChild(behaviour);

        listenerGroup.addChild(sphere);
        //group.addChild(new ColorCube(0.3));
        SimpleUniverse universe = new SimpleUniverse(canvas3D.getOffscreenCanvas3D());

        Color3f light1Color = new Color3f(1.8f, 0.1f, 0.1f);
        //Color3f light1Color = new Color3f(.1f, 1.4f, .1f); // green light

        BoundingSphere bounds = new BoundingSphere(new Point3d(0.0,0.0,0.0), 100.0);

        Vector3f light1Direction = new Vector3f(4.0f, -7.0f, -12.0f);

        DirectionalLight light1

                = new DirectionalLight(light1Color, light1Direction);

        Background background = new Background(new Color3f(Color.GRAY));
        background.setApplicationBounds(bounds);

        light1.setInfluencingBounds(bounds);

        group.addChild(light1);

        group.addChild(background);

        universe.getViewingPlatform().setNominalViewingTransform();
        universe.addBranchGraph(group);
        //universe.addBranchGraph(createSceneGraph(canvas3D));
    }
    private static BranchGroup createSceneGraph(JCanvas3D canvas3D) {
        BranchGroup objRoot = new BranchGroup();

        TransformGroup listenerGroup = new TransformGroup();
        listenerGroup.setCapability(TransformGroup.ALLOW_TRANSFORM_WRITE);
        listenerGroup.setCapability(TransformGroup.ALLOW_TRANSFORM_READ);
        objRoot.addChild(listenerGroup);

        //KeyNavigatorBehavior behaviour = new KeyNavigatorBehavior(listenerGroup);
        MouseRotate behaviour = new MouseRotate(canvas3D, listenerGroup);
        behaviour.setSchedulingBounds(new BoundingSphere(new Point3d(), 100));

        listenerGroup.addChild(behaviour);
        listenerGroup.addChild(new ColorCube(0.4));

        return objRoot;
    }

}
