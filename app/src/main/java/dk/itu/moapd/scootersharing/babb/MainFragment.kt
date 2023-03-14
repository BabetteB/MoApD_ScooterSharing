/*MIT License

Copyright (c) [2023] [Babette & Freyja]

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NON INFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
SOFTWARE.*/

package dk.itu.moapd.scootersharing.babb

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import dk.itu.moapd.scootersharing.babb.databinding.FragmentMainBinding

/**
 * The main fragment containing sub-fragments
 */
class MainFragment : Fragment() {

    /**
     * The view binding for the Main fragment - can be null'ed upon destruction
     */
    private var _binding : FragmentMainBinding? = null
    private val binding
        get() = checkNotNull(_binding) {
            "Oh no I died"
        }

    /**
     * upon creating the view for the main fragment, set and inflate the binding (see fragment_main.xml)
     * @return View that holds the fragment container
     * @property inflater, the inflater we pass to the onCreateView - Here, a LayoutInflater
     * @property container, the ViewGroup passed to onCreateView, used to contain other Views.
     * @property savedInstanceState, a mapping of saved components in a Bundle.
     */
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentMainBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

}