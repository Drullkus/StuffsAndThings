package com.drullkus.StuffsAndThings.Renderer;


import codechicken.lib.colour.ColourRGBA;
import codechicken.lib.render.TextureFX;
import net.minecraft.util.MathHelper;

public class TestingAnimFX extends TextureFX {

    protected float[] red = new float[16];
    protected float[] green = new float[16];
    protected float[] blue = new float[16];
    protected float[] alpha = new float[16];

    public TestingAnimFX(int size) {
        super(size, "crack");
    }

    public void setup()
    {
        super.setup();

        this.red = new float[this.tileSizeSquare];
        this.green = new float[this.tileSizeSquare];
        this.blue = new float[this.tileSizeSquare];
        this.alpha = new float[this.tileSizeSquare];
    }

    public void onTick()
    {
        for (int y = 0; y < this.tileSizeBase; y++)
        {
            for (int x = 0; x < this.tileSizeBase; x++)
            {
                float vec1 = -(getOppositeNumber(y)+x)/tileSizeBase;


            }
        }

        for (int var2 = 0; var2 < this.tileSizeSquare; var2++) {
            float var3 = 0;

            if (var3 > 1.0F) {
                var3 = 1.0F;
            }

            if (var3 < 0.0F) {
                var3 = 0.0F;
            }

            int var5 = (int)(var3 * 255.0F);
            int var6 = (int)(var3 * 255.0F);
            int var7 = (int)(var3 * 255.0F);

            if (this.anaglyphEnabled) {
                int var8 = (var5 * 30 + var6 * 59 + var7 * 11) / 100;
                int var9 = (var5 * 30 + var6 * 70) / 100;
                int var10 = (var5 * 30 + var7 * 70) / 100;
                var5 = var8;
                var6 = var9;
                var7 = var10;
            }

            this.imageData[var2] = setColourRGBAFromInt((int)var3);
        }
    }

    public int getOppositeNumber(int num)
    {
        return MathHelper.abs_int(-num+this.tileSizeBase);
    }

    public int setColourRGBAFromInt(int color)
    {
        float red = (color >> 16 & 255) / 255.0F;
        float green = (color >> 8 & 255) / 255.0F;
        float blue = (color & 255) / 255.0F;
        return new ColourRGBA(red, green, blue, -1).argb();
    }
}
