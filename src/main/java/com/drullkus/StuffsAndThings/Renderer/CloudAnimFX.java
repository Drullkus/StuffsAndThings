package com.drullkus.StuffsAndThings.Renderer;

import codechicken.lib.colour.ColourRGBA;
import codechicken.lib.render.TextureFX;
import net.minecraft.util.MathHelper;

public class CloudAnimFX extends TextureFX {

    protected float[] red = new float[16];
    protected float[] green = new float[16];
    protected float[] blue = new float[16];
    protected float[] alpha = new float[16];

    public CloudAnimFX(int size) {
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
        for (int i = 0; i < this.tileSizeBase; i++) {
            for (int j = 0; j < this.tileSizeBase; j++) {
                float v3 = -0.05F;
                int rotation1 = (int)(MathHelper.abs_int((int) (j * 3.141593F * 3.0F / 2.0F)) * 1.0F);
                int rotation2 = (int)(MathHelper.abs_int((int) (i * 3.141593F * 3.0F / 2.0F)) * 1.0F);

                for (int k = i - 1; k <= i + 1; k++) {
                    for (int l = j - 1; l <= j + 1; l++) {
                        int mod1 = k + rotation1 & this.tileSizeMask;
                        int mod2 = l + rotation2 & this.tileSizeMask;
                        v3 += this.red[(mod1 + mod2 * this.tileSizeBase)];
                    }
                }

                this.green[(i + j * this.tileSizeBase)] = (v3 / 10.0F + (this.blue[((i + 0 & this.tileSizeMask) + (j + 0 & this.tileSizeMask) * this.tileSizeBase)] + this.blue[((i + 1 & this.tileSizeMask) + (j + 0 & this.tileSizeMask) * this.tileSizeBase)] + this.blue[((i + 1 & this.tileSizeMask) + (j + 1 & this.tileSizeMask) * this.tileSizeBase)] + this.blue[((i + 0 & this.tileSizeMask) + (j + 1 & this.tileSizeMask) * this.tileSizeBase)]) / 4.0F * 0.8F);
                this.blue[(i + j * this.tileSizeBase)] += this.alpha[(i + j * this.tileSizeBase)] * 0.01F;

                if (this.blue[(i + j * this.tileSizeBase)] < 0.0F) {
                    this.blue[(i + j * this.tileSizeBase)] = 0.0F;
                }

                this.alpha[(i + j * this.tileSizeBase)] -= 0.062F;

                if (Math.random() >= 0.0062D)
                    continue;
                this.alpha[(i + j * this.tileSizeBase)] = 1.33F;
            }

        }

        float[] var11 = this.green;
        this.green = this.red;
        this.red = var11;

        for (int var2 = 0; var2 < this.tileSizeSquare; var2++) {
            float var3 = this.red[var2] * 2.0F;

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

            this.imageData[var2] = new ColourRGBA(var5, var6, var7, -1).argb();
        }
    }
}
