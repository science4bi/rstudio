/*
 * ChunkDefinition.java
 *
 * Copyright (C) 2009-16 by RStudio, Inc.
 *
 * Unless you have received this program directly from RStudio pursuant
 * to the terms of a commercial license agreement with RStudio, then
 * this program is licensed to you under the terms of version 3 of the
 * GNU Affero General Public License. This program is distributed WITHOUT
 * ANY EXPRESS OR IMPLIED WARRANTY, INCLUDING THOSE OF NON-INFRINGEMENT,
 * MERCHANTABILITY OR FITNESS FOR A PARTICULAR PURPOSE. Please refer to the
 * AGPL (http://www.gnu.org/licenses/agpl-3.0.txt) for more details.
 *
 */
package org.rstudio.studio.client.workbench.views.source.editors.text.rmd;

import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.core.client.JsArray;

public class ChunkDefinition extends JavaScriptObject
{
   public static final String LINE_WIDGET_TYPE = "ChunkOutput";
   
   protected ChunkDefinition()
   {
   }
   
   public static native final ChunkDefinition create(int row,
                                                 int rowCount,
                                                 boolean visible,
                                                 String chunkId) /*-{
      return {
        row: row,
        row_count: rowCount,
        visible: visible,
        chunk_id: chunkId
      };
   }-*/;
   
   public final ChunkDefinition withRow(int row)
   {
      return ChunkDefinition.create(row, getRowCount(), getVisible(), 
            getChunkId());
   }
   
   public native final int getRow()  /*-{
      return this.row;
   }-*/;
   
   public native final int getRowCount()  /*-{
      return this.row_count;
   }-*/;
   
   public native final boolean getVisible() /*-{
      return this.visible;
   }-*/;   
   
   public native final String getChunkId() /*-{
      return this.chunk_id;
   }-*/;
   
   
   public final boolean equalTo(ChunkDefinition other)
   {
      return getRow() == other.getRow() &&
             getRowCount() == other.getRowCount() &&
             getVisible() == other.getVisible() &&
             getChunkId() == other.getChunkId();
   }
   
   
   public final static boolean equalTo(JsArray<ChunkDefinition> a, 
                                       JsArray<ChunkDefinition> b)
   {
      if (a.length() != b.length())
         return false;
      
      for (int i = 0; i<a.length(); i++)
         if (!a.get(i).equalTo(b.get(i)))
            return false;
      
      return true;
   }
   
   
}
