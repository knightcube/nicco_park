package com.example.niccopark.activity;

import android.net.Uri;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.widget.Button;
import android.widget.Toast;

import com.example.niccopark.fragment.CustomARFragment;
import com.example.niccopark.R;
import com.google.ar.core.Anchor;
import com.google.ar.core.Config;
import com.google.ar.core.Session;

import com.google.ar.sceneform.AnchorNode;
import com.google.ar.sceneform.FrameTime;
import com.google.ar.sceneform.Scene;
import com.google.ar.sceneform.SkeletonNode;
import com.google.ar.sceneform.animation.ModelAnimator;
import com.google.ar.sceneform.rendering.AnimationData;
import com.google.ar.sceneform.rendering.ModelRenderable;
import com.google.ar.sceneform.ux.TransformableNode;

public class AttractionsActivity extends AppCompatActivity implements Scene.OnUpdateListener {

    private CustomARFragment arFragment;
    public static final String TAG = "AttractionsActivity";
    private Button hulkBtn, ironmanBtn;
    private String modelUri;
    private FloatingActionButton fab;
    private ModelAnimator modelAnimator;
    private int i;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_attractions);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ActionBar actionbar = getSupportActionBar();
        actionbar.setDisplayHomeAsUpEnabled(true);
        actionbar.setHomeAsUpIndicator(R.drawable.ic_arrow_back);
        arFragment = (CustomARFragment) getSupportFragmentManager().findFragmentById(R.id.ar_fragment);
        hulkBtn = findViewById(R.id.hulk_btn);
        fab = findViewById(R.id.floatingActionButton);
        ironmanBtn = findViewById(R.id.iron_man_btn);
//        hulkBtn.setOnClickListener(v -> modelUri = "jumping.sfb");
//        ironmanBtn.setOnClickListener(v -> modelUri = "aerial_evade.sfb");
        arFragment.setOnTapArPlaneListener((hitResult, plane, motionEvent) -> createModel(hitResult.createAnchor(),modelUri));
//        arFragment.getArSceneView().getScene().addOnUpdateListener(this);


    }

    private void createModel(Anchor anchor, String s) {
        ModelRenderable.builder()
                .setSource(this, Uri.parse(s))
                .build()
                .thenAccept(modelRenderable ->{
                    placeModel(modelRenderable, anchor);
                })
                .exceptionally(
                        throwable -> {
                            Log.e(TAG, "Unable to load Renderable.", throwable);
                            return null;
                        })
        ;
    }


    public void setupDatabase(Config config, Session session) {
//        Bitmap markerBitmap = BitmapFactory.decodeResource(getResources(), R.drawable.marker);
//        Bitmap parkBitmap = BitmapFactory.decodeResource(getResources(), R.drawable.nicco_park_one);
//
//        AugmentedImageDatabase aid = new AugmentedImageDatabase(session);
//        aid.addImage("marker", markerBitmap);
//        aid.addImage("nicco_park", parkBitmap);
//        Log.i(TAG, "number of augmented images: " + aid.getNumImages());
//        config.setAugmentedImageDatabase(aid);
    }

    @Override
    public void onUpdate(FrameTime frameTime) {

//        Frame frame = arFragment.getArSceneView().getArFrame();
//        Collection<AugmentedImage> images = frame.getUpdatedTrackables(AugmentedImage.class);
//        Log.i(TAG, "onUpdate: Image array size" + images.size());
//        for (AugmentedImage image : images) {
//            Log.i(TAG, "onUpdate: " + image.getTrackingState());
//            if (image.getTrackingState() == TrackingState.TRACKING) {
//                Log.i(TAG, "onUpdate: Tracking ");
//                if (image.getName().equals("marker")) {
//
////                        MyArNode node = new MyArNode(this,R.)
//
//
//                    Log.i(TAG, "onUpdate: Index found");
//                    Anchor anchor = image.createAnchor(image.getCenterPose());
//                    createAndyModel(anchor);
//                }
//                if (image.getName().equals("nicco_park")) {
//
////                        MyArNode node = new MyArNode(this,R.)
//
//
//                    Log.i(TAG, "onUpdate: Index found");
//                    Anchor anchor = image.createAnchor(image.getCenterPose());
//                    createFerrisModel(anchor);
//                }
//            }
//        }


//        Frame frame = null;
//        try {
//            frame = session.update();
//            Collection<AugmentedImage> images = frame.getUpdatedTrackables(AugmentedImage.class);
//            Log.i(TAG, "onUpdate: Image array size"+images.size());
//            for(AugmentedImage image:images){
//                Log.i(TAG, "onUpdate: "+image.getTrackingState());
//                if(image.getTrackingState()==TrackingState.TRACKING){
//                    Log.i(TAG, "onUpdate: Tracking ");
//                    if(image.getIndex() == index){
//                        Log.i(TAG, "onUpdate: Index found");
//                        Anchor anchor = image.createAnchor(image.getCenterPose());
//                        createModel(anchor);
//                    }
//                }
//            }
//
//        } catch (CameraNotAvailableException e) {
//            e.printStackTrace();
//        }

    }

    private void placeModel(ModelRenderable modelRenderable, Anchor anchor) {
        AnchorNode anchorNode = new AnchorNode(anchor);
        TransformableNode transformableNode = new TransformableNode(arFragment.getTransformationSystem());
        transformableNode.setParent(anchorNode);
        transformableNode.select();
        SkeletonNode skeletonNode = new SkeletonNode();
        skeletonNode.setParent(anchorNode);

        transformableNode.setRenderable(modelRenderable);

//        skeletonNode.setRenderable(modelRenderable);
//        anchorNode.setRenderable(modelRenderable);
        arFragment.getArSceneView().getScene().addChild(anchorNode);
        fab.setOnClickListener(v -> {
            animateModel(modelRenderable);
        });
    }

    private void animateModel(ModelRenderable modelRenderable) {
        if((modelAnimator!=null) &&(modelAnimator.isRunning())){
            modelAnimator.end();
        }
        int animationCount = modelRenderable.getAnimationDataCount();

        if(i==animationCount)i=0;

        if(modelRenderable.getAnimationDataCount()>0) {
            AnimationData animationData = modelRenderable.getAnimationData(i);
            modelAnimator = new ModelAnimator(animationData, modelRenderable);
            modelAnimator.start();
            i++;
        }else{
            Toast.makeText(this, "No animation available for this model", Toast.LENGTH_SHORT).show();
        }
    }
}
