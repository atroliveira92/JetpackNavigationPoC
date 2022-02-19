package com.venmo.features.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.venmo.commons.navigation.InternalDeepLink
import com.venmo.commons.navigation.routers.ProfileRouter
import com.venmo.commons.navigation.routers.SettingsRouter
import com.venmo.features.home.databinding.FragmentHomeBinding
import org.koin.android.ext.android.inject

class HomeFragment: Fragment() {

    private val profileRouter by inject<ProfileRouter>()
    private val settingsRouter by inject<SettingsRouter>()

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnGoToProfile.setOnClickListener {
            profileRouter.navigate(findNavController())
            //findNavController().navigate(InternalDeepLink.goToProfile())
        }

        binding.btnGoToSettings.setOnClickListener {
            settingsRouter.navigate(requireActivity())
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}