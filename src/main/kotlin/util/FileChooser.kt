package util

import androidx.compose.ui.awt.ComposeWindow
import androidx.compose.ui.window.Window
import java.io.File
import javax.swing.JFileChooser
import javax.swing.filechooser.FileFilter


private val user=System.getenv("USERPROFILE")
fun OpenFileDialog(onSelectedPath:(List<String>)->Unit){

    val fileChooser = JFileChooser()

    fileChooser.isMultiSelectionEnabled=true
    fileChooser.currentDirectory= File("C:\\Users\\$user\\Downloads")

    fileChooser.fileFilter=
        object : FileFilter(){
            override fun accept(f: File?): Boolean {

                f?.let {

                    if(f.isDirectory){
                        return true
                    }
                }

                val fileName = f?.name?.toLowerCase()!!
                return fileName.endsWith(".jpg") || fileName.endsWith(".png")
            }

            override fun getDescription(): String {
                return  "Image Files(*.jpg, *.png)"
            }

        }

    val result = fileChooser.showOpenDialog(ComposeWindow())

    if (result == JFileChooser.APPROVE_OPTION) {
        val selectedFiles = fileChooser.selectedFiles
        onSelectedPath(selectedFiles.map { it.absolutePath })

    }
}