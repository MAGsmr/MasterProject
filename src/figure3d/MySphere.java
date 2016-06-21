package figure3d;

import com.sun.j3d.exp.swing.JCanvas3D;
import com.sun.j3d.utils.behaviors.mouse.MouseRotate;
import com.sun.j3d.utils.geometry.Sphere;
import com.sun.j3d.utils.universe.SimpleUniverse;

import javax.media.j3d.*;
import javax.vecmath.Color3f;
import javax.vecmath.Point3d;
import javax.vecmath.Vector3f;
import java.awt.*;

/**
 * Created by Анатолий on 01.05.2016.
 */
public class MySphere {
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

        SimpleUniverse universe = new SimpleUniverse(canvas3D.getOffscreenCanvas3D());

        Color3f light1Color = new Color3f(1.8f, 0.1f, 0.1f);
        //Color3f light1Color = new Color3f(.1f, 1.4f, .1f); // green light

        BoundingSphere bounds = new BoundingSphere(new Point3d(0.0,0.0,0.0), 100.0);

        Vector3f light1Direction = new Vector3f(4.0f, -7.0f, -12.0f);

        DirectionalLight light1 = new DirectionalLight(light1Color, light1Direction);

        Background background = new Background(new Color3f(Color.GRAY));
        background.setApplicationBounds(bounds);

        light1.setInfluencingBounds(bounds);

        group.addChild(light1);

        group.addChild(background);

        universe.getViewingPlatform().setNominalViewingTransform();
        universe.addBranchGraph(group);
    }
}
