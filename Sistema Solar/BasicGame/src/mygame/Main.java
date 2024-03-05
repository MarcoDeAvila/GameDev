package mygame;

import com.jme3.app.SimpleApplication;
import com.jme3.material.Material;
import com.jme3.math.ColorRGBA;
import com.jme3.math.FastMath;
import com.jme3.post.FilterPostProcessor;
import com.jme3.post.filters.BloomFilter;
import com.jme3.renderer.RenderManager;
import com.jme3.scene.Geometry;
import com.jme3.scene.Node;
import com.jme3.scene.Spatial;
import com.jme3.scene.shape.Box;
import com.jme3.scene.shape.Sphere;
import com.jme3.post.filters.CartoonEdgeFilter;
import com.jme3.renderer.queue.RenderQueue;

/**
 * This is the Main Class of your Game. You should only do initialization here.
 * Move your Logic into AppStates or Controls
 * @author normenhansen
 */
public class Main extends SimpleApplication {
    public Spatial spatial_var = null;
    public Spatial sol_spatial = null;
    public Spatial p1_spatial = null;
    public Spatial p2_spatial = null;
    public Spatial p3_spatial = null;
    public Spatial p4_spatial = null;
    public Spatial p5_spatial = null;
    

    
    private FilterPostProcessor fpp;

    public static void main(String[] args) {
        Main app = new Main();
        app.start();
    }

    @Override
    public void simpleInitApp() {
        Node sistema = new Node("sistema");
        
        // sol
        Sphere sol = new Sphere(128, 128, 1, false, true);
        Geometry sol_geom = new Geometry("sol", sol);
        Material sol_mat = new Material(assetManager, "Common/MatDefs/Misc/ShowNormals.j3md");
        sol_geom.setMaterial(sol_mat);
        sol_geom.move(0, 0, 0);
        
        
        
        // Planetas
        Sphere planeta_1 = new Sphere(128, 128, 1f, false, true);
        Geometry planeta1_geom = new Geometry("planeta1", planeta_1);
        Material planeta1_mat = new Material(assetManager, "Common/MatDefs/Misc/Unshaded.j3md");
        planeta1_geom.setMaterial(planeta1_mat);
        planeta1_mat.setColor("Color", ColorRGBA.randomColor());
        planeta1_geom.move(1, 0, 1);
        planeta1_geom.scale(0.2f);
        
        
        Sphere planeta_2 = new Sphere(128, 128, 1f, false, true);
        Geometry planeta2_geom = new Geometry("planeta2", planeta_2);
        Material planeta2_mat = new Material(assetManager, "Common/MatDefs/Misc/Unshaded.j3md");
        planeta2_mat.setColor("Color", ColorRGBA.randomColor());
        planeta2_geom.setMaterial(planeta2_mat);
        planeta2_geom.move(2, -1, 1);
        planeta2_geom.scale(0.4f);
        
        Sphere planeta_3 = new Sphere(128, 128, 1f, false, true);
        Geometry planeta3_geom = new Geometry("planeta3", planeta_3);
        Material planeta3_mat = new Material(assetManager, "Common/MatDefs/Misc/Unshaded.j3md");
        planeta3_mat.setColor("Color", ColorRGBA.randomColor());
        planeta3_geom.setMaterial(planeta3_mat);
        planeta3_geom.move(2, 1, 2);
        planeta3_geom.scale(0.5f);
        
        Sphere planeta_4 = new Sphere(128, 128, 1f, false, true);
        Geometry planeta4_geom = new Geometry("planeta4", planeta_4);
        Material planeta4_mat = new Material(assetManager, "Common/MatDefs/Misc/Unshaded.j3md");
        planeta4_mat.setColor("Color", ColorRGBA.randomColor());
        planeta4_geom.setMaterial(planeta4_mat);
        planeta4_geom.move(-2, 1, -2);
        planeta4_geom.scale(0.3f);
        
        Sphere planeta_5 = new Sphere(128, 128, 1f, false, true);
        Geometry planeta5_geom = new Geometry("planeta5", planeta_5);
        Material planeta5_mat = new Material(assetManager, "Common/MatDefs/Misc/Unshaded.j3md");
        planeta5_mat.setColor("Color", ColorRGBA.randomColor());
        planeta5_geom.setMaterial(planeta5_mat);
        planeta5_geom.move(-2, -1, -1);
        planeta5_geom.scale(0.6f);
        
        
        // Filtro
        fpp= new FilterPostProcessor(assetManager);
        BloomFilter bloom = new BloomFilter();
        bloom.setBloomIntensity(5);
        
        CartoonEdgeFilter cartoon = new CartoonEdgeFilter();
        fpp.addFilter(cartoon);
        
        fpp.addFilter(bloom);
      
        viewPort.addProcessor(fpp);     
        
        sistema.attachChild(sol_geom);
        sistema.attachChild(planeta1_geom);
        sistema.attachChild(planeta2_geom);
        sistema.attachChild(planeta3_geom);
        sistema.attachChild(planeta4_geom);
        sistema.attachChild(planeta5_geom);
        rootNode.attachChild(sistema);
    }

    @Override
    public void simpleUpdate(float tpf) {
        if(spatial_var == null){
            spatial_var = rootNode.getChild("sistema");
            sol_spatial = rootNode.getChild("sol");
            p1_spatial = rootNode.getChild("planeta1");
            p2_spatial = rootNode.getChild("planeta2");
            p3_spatial = rootNode.getChild("planeta3");
            p4_spatial = rootNode.getChild("planeta4");
            p5_spatial = rootNode.getChild("planeta5");
        }
        
        spatial_var.rotate(0, tpf/4, 0);
        sol_spatial.rotate(0, -(tpf*2), 0);
        p1_spatial.rotate(0, tpf, 0);
        p2_spatial.rotate(0, tpf, 0);
        p3_spatial.rotate(0, tpf, 0);
        p4_spatial.rotate(0, tpf, 0);
        p5_spatial.rotate(0, tpf, 0);
    }

    @Override
    public void simpleRender(RenderManager rm) {
        //TODO: add render code
    }
}
