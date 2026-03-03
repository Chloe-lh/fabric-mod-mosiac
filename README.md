# Mosiac Mod

A Fabric mod that adds fully customizable ceramic tiles to Minecraft.  
Paint tiles in four quadrants to create mosaics, murals, pixel art, and decorative patterns.

## Features

### Ceramic Tile Block
- Crafted from clay.
- Paintable in four quadrants.
- Stores paint data per block.

### Paint Brush
- Used in the **main hand**.
- Detects click position to determine which quadrant is painted.
- Applies paint to the selected quadrant.

### Paint Bucket
- Held in the **offhand**.
- Crafted using a water bucket + dye.
- Provides color to the paint brush.

---

## How It Works

1. Craft a Ceramic Tile block.
2. Craft a Paint brush.
3. Craft a Paint Bucket using a water bucket and dye.
4. Place:
   - Paint Brush in your **main hand**
   - Paint Bucket in your **offhand**
5. Right-click a ceramic tile.
6. The clicked quadrant is painted with the bucket’s color.
Each tile stores 4 colors:
```
[0][1]
[2][3]
```

## Version
Minecraft: 1.21.11
Fabric Loader: 0.18.4
Java: 21
