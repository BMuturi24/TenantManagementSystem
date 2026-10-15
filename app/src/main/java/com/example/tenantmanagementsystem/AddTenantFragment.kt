package com.example.tenantmanagementsystem

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.tenantmanagementsystem.databinding.FragmentAddTenantsBinding
class AddTenantFragment : Fragment() {
    private var _binding: FragmentAddTenantsBinding? = null
    private val binding get() = _binding!!
    private var saveCount = 0

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentAddTenantsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
// The SAVE button is added in Practical 3
   binding.saveButton.setOnClickListener {
       saveCount++
       Toast.makeText(requireContext(),"Saved details $saveCount times", Toast.LENGTH_LONG).show()
   }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putInt("SAVE_COUNT_KEY", saveCount)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // Check if there is saved state, and if so, retrieve the integer. Default to 0.
        if (savedInstanceState != null) {
            saveCount = savedInstanceState.getInt("SAVE_COUNT_KEY", 0)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}
