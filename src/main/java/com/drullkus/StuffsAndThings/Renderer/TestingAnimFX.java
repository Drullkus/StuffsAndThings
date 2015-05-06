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

    public void onTick() {
        for (int y = 0; y < this.tileSizeBase; y++) {
            for (int x = 0; x < this.tileSizeBase; x++) {

                float v3 = -0.05F; // Set Constant I guess

                //
                int rotation1 = (int)(MathHelper.abs_int((int) (y * 3.141593F * 3.0F / 2.0F)) * 1.0F);
                int rotation2 = (int)(MathHelper.abs_int((int) (x * 3.141593F * 3.0F / 2.0F)) * 1.0F);

                for (int k = y - 1; k <= y + 1; k++)
                {
                    for (int l = x - 1; l <= x + 1; l++)
                    {
                        int mod1 = k + rotation1 & this.tileSizeMask;
                        int mod2 = l + rotation2 & this.tileSizeMask;
                        v3 += this.red[(mod1 + mod2 * this.tileSizeBase)];
                    }
                }

                this.green[(y + x * this.tileSizeBase)] =
                        (v3 / 10.0F +
                                (this.blue[((y + 0 & this.tileSizeMask) + (x + 0 & this.tileSizeMask) * this.tileSizeBase)]
                                        + this.blue[((y + 1 & this.tileSizeMask) + (x + 0 & this.tileSizeMask) * this.tileSizeBase)]
                                        + this.blue[((y + 1 & this.tileSizeMask) + (x + 1 & this.tileSizeMask) * this.tileSizeBase)]
                                        + this.blue[((y + 0 & this.tileSizeMask) + (x + 1 & this.tileSizeMask) * this.tileSizeBase)])
                                        / 4.0F * 0.8F);


                this.blue[(y + x * this.tileSizeBase)] += this.alpha[(y + x * this.tileSizeBase)] * 0.01F;

                if (this.blue[(y + x * this.tileSizeBase)] < 0.0F) {
                    this.blue[(y + x * this.tileSizeBase)] = 0.0F;
                }

                this.alpha[(y + x * this.tileSizeBase)] -= 0.062F;

                if (Math.random() >= 0.0062D)
                    continue;
                this.alpha[(y + x * this.tileSizeBase)] = 1.33F;
            }
        }

        float[] var11 = this.green;
        this.green = this.red;
        this.red = var11;

        for (int var2 = 0; var2 < this.tileSizeSquare; var2++) {
            float var3 = this.red[var2] * 3.0F;

            if (var3 > 1.0F)
            {
                var3 = 1.0F;
            }

            if (var3 < 0.0F)
            {
                var3 = 0.0F;
            }

            int var5;
            int var6;
            int var7;

            if (var3 < 1.0F/6.0F)
            {
                var5 = 255;
                var6 = (int)(var3 * 255.0F);
                var7 = 0;
            }
            else if (var3 < 2.0F/6.0F)
            {
                var5 = 255-(int)(var3 * 255.0F);
                var6 = 255;
                var7 = 0;
            }
            else if (var3 < 3.0F/6.0F)
            {
                var5 = 0;
                var6 = 255;
                var7 = (int)(var3 * 255.0F);
            }
            else if (var3 < 4.0F/6.0F)
            {
                var5 = 0;
                var6 = 255-(int)(var3 * 255.0F);
                var7 = 255;
            }
            else if (var3 < 5.0F/6.0F)
            {
                var5 = (int)(var3 * 255.0F);
                var6 = 0;
                var7 = 255;
            }
            else if (var3 <= 6.0F/6.0F)
            {
                var5 = 255;
                var6 = 0;
                var7 = 255-(int)(var3 * 255.0F);
            }
            else
            {
                var5 = (int)(var3 * 255.0F);
                var6 = (int)(var3 * 255.0F);
                var7 = (int)(var3 * 255.0F);
            }//*/

            if (this.anaglyphEnabled) {
                int var8 = (var5 * 30 + var6 * 59 + var7 * 11) / 100;
                int var9 = (var5 * 30 + var6 * 70) / 100;
                int var10 = (var5 * 30 + var7 * 70) / 100;
                var5 = var8;
                var6 = var9;
                var7 = var10;
            }

            this.imageData[var2] = new ColourRGBA(var5, var6, var7, -1).argb();
        }
    }

    public int setColourRGBAFromInt(int color)
    {
        float red = (color >> 16 & 255) / 255.0F;
        float green = (color >> 8 & 255) / 255.0F;
        float blue = (color & 255) / 255.0F;
        return new ColourRGBA(red, green, blue, -1).argb();
    }
}
