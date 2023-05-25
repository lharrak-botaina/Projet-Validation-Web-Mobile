package prototype.todolist.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import prototype.todolist.R
import prototype.todolist.databinding.FragmentTaskManagerBinding


class TestFragment : Fragment() {
    private var _binding: FragmentTaskManagerBinding? = null
    private val binding get() = _binding!!
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Retrieve and inflate the layout for this fragment
        _binding = FragmentTaskManagerBinding.inflate(inflater, container, false)
        val view = binding.root
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Access the TextView and set its text to the desired value
        val textView = view.findViewById<TextView>(R.id.textView)
        textView.text = getString(R.string.test_text)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}